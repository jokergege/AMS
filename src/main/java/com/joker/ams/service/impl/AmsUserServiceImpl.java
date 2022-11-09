package com.joker.ams.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.joker.ams.common.LoginUser;
import com.joker.ams.common.ResultVo;
import com.joker.ams.dao.AmsUserDao;
import com.joker.ams.dao.AmsUserRoleDao;
import com.joker.ams.entity.AmsUser;
import com.joker.ams.entity.AmsUserRole;
import com.joker.ams.service.AmsUserService;
import com.joker.ams.utils.JwtUtil;
import com.joker.ams.utils.MsgUtil;
import com.joker.ams.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 用户表(AmsUser)表服务实现类
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
@Service("amsUserService")
public class AmsUserServiceImpl implements AmsUserService {
    @Resource
    private AmsUserDao amsUserDao;
    @Resource
    private AmsUserRoleDao amsUserRoleDao;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    RedisCache redisCache;
    @Autowired
    PasswordEncoder passwordEncoder;
    /**
     * 用户登陆
     * @param user
     * @return
     */
    @Override
    public ResultVo userLogin(AmsUser user) {
        // 3.使用provideManager authentication方法进行验证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //校验失败
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名密码错误!");
        }else {
            LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
            String userId = loginUser.getUser().getId().toString();
            Map map = new HashMap<>();
            //4.生成jwt给前端
            String jwt = JwtUtil.createJWT(userId);
            map.put("token", jwt);
            map.put("user",loginUser.getUser());
            //5.系统用户相关信息保存到redis中
            redisCache.setCacheObject("login:" + userId, loginUser);
            return new ResultVo(200, "登陆成功", map);
        }
    }

    /**
     * 用户登出
     * @return
     */
    @Override
    public ResultVo userLogout() {
        //从SecurityContextHolder取出信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser user = (LoginUser) authentication.getPrincipal();
        Long user_id = user.getUser().getId();
        redisCache.deleteObject("login:" + user_id);
        return new ResultVo(200,"退出成功");
    }

    /**
     * 自动登陆
     * @return
     */
    @Override
    public ResultVo tokenLogin(String token) {
        HashMap<String, Object> map = new HashMap<>();
        Claims claims ;
        String userID;
        try {
            claims = JwtUtil.parseJWT(token);
            userID= claims.getSubject();
        } catch (Exception e) {
           return new  ResultVo(201,"登陆过期请重新登陆");
        }
        //获取
        LoginUser user = redisCache.getCacheObject("login:"+userID);
        map.put("user",user.getUser());
        if (Objects.isNull(user)){
            return new ResultVo(201,"用户未登录");
        }
        else {
            return new ResultVo(200,"登陆成功",map);
        }
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @Override
    public ResultVo insertUser(AmsUser user) {
        AmsUserRole amsUserRole=new AmsUserRole();
        synchronized (this) {
        AmsUser user1=amsUserDao.queryUserByName(user.getUserName());
            if (user1==null){
                AmsUser user2=amsUserDao.queryUserByPhone(user.getPhoneNumber());
                if (Objects.isNull(user2)){
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    user.setCreateTime(new Date());
                    user.setUserType("1");
                    user.setStatus("0");
                    Long i=amsUserDao.insert(user);
                    if (i==0){
                        return  new ResultVo(201,"注册失败");
                    }else {
                        amsUserRole.setUserId(user.getId());
                        long role=1;
                        Long role_id=role;
                        amsUserRole.setRoleId(role_id);
                        amsUserRoleDao.insert(amsUserRole);
                        return  new ResultVo(200,"注册成功");
                    }
                }else {
                    return  new ResultVo(201,"此电话已被绑定");
                }

            }else {
                return  new ResultVo(201,"用户已被注册");
            }
        }
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public ResultVo getUserList(Integer page, Integer size) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(page);
        System.out.println(size);
        System.out.println("list=>");
        System.out.println(amsUserDao.getUserList((page - 1) * size, size));
        map.put("users", amsUserDao.getUserList((page - 1) * size, size));
            map.put("totalCount", amsUserDao.getUserCount());
            return new ResultVo(200, "success", map);
    }

    String code = "";
    AmsUser user_captcha = new AmsUser();

    /**
     * 得到验证码
     * @param phoneNumber
     * @return
     */
    @Override
    public ResultVo doGetCaptcha(String phoneNumber) {
        user_captcha = amsUserDao.queryUserByPhone(phoneNumber);
        if (user_captcha == null) {
            return new ResultVo(201, "用户不存在");
        } else {
            JSONObject jsonObject = JSONObject.parseObject(MsgUtil.SendSms(phoneNumber));
            code = (String) jsonObject.get("code");
            return new ResultVo(200, "用户存在,请等待验证码");
        }
    }

    /**
     * 校验验证码
     * @param captcha
     * @return
     */
    @Override
    public ResultVo doSendCaptcha(String captcha) {
        if (code.equals(captcha)) {
            return new ResultVo(200, "用户身份验证成功", user_captcha.getUserName());
        } else {
            return new ResultVo(201, "验证异常");
        }
    }

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    @Override
    public ResultVo doUpdatePassword(AmsUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int id = amsUserDao.updatePassword(user.getPassword(),user.getUserName());
        if (id > 0) {
            return new ResultVo(200, "修改成功");
        } else {
            return new ResultVo(201, "修改失败");
        }
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResultVo queryById(int id) {
        AmsUser user =amsUserDao.queryById(id);
        if (!Objects.isNull(user)){
            return new ResultVo(200,"查询成功",user);
        }else {
            return new ResultVo(201,"查询失败");
        }
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.amsUserDao.deleteById(id) > 0;
    }
}
