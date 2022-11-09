package com.joker.ams.service.impl;

import com.joker.ams.common.LoginUser;
import com.joker.ams.dao.AmsMenuDao;
import com.joker.ams.dao.AmsUserDao;
import com.joker.ams.entity.AmsUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    AmsMenuDao menuDao;
    @Resource
    AmsUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.根据用户名获取数据库中的系统用户
        AmsUser user = userDao.queryUserByName(username);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在");
        }
        //2.查询权限信息
        List<String> perms = menuDao.selectPermsByUserId(user.getId());
        //List<String> perms=new ArrayList<>(Arrays.asList("sayhello","delgoods"));
        //3.返回userDetails

        return new LoginUser(user, perms);
    }
}
