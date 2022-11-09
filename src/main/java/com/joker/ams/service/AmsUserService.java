package com.joker.ams.service;

import com.joker.ams.common.ResultVo;
import com.joker.ams.entity.AmsUser;

/**
 * 用户表(AmsUser)表服务接口
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
public interface AmsUserService {


    /**
     * 用户第一次登陆
     * @param user
     * @return
     */
    ResultVo userLogin(AmsUser user);

    /**
     * 登出
     * @return
     */
    ResultVo userLogout();

    /**
     * token自动登陆
     * @return
     */
    ResultVo tokenLogin(String token);

    /**
     * 用户注册
     * @param user
     * @return
     */
    ResultVo insertUser(AmsUser user);

    /**
     * 查询所有的用户数据
     * @param page
     * @param size
     * @return
     */
    ResultVo getUserList(Integer page, Integer size);

    /**
     * 得到验证码
     * @param phoneNumber
     * @return
     */
    ResultVo doGetCaptcha(String phoneNumber);

    /**
     * 进行验证码校验
     * @param captcha
     * @return
     */
    ResultVo doSendCaptcha(String captcha);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ResultVo queryById(int id);

    /**
     * 更新用户密码
     * @param user
     * @return
     */
    ResultVo doUpdatePassword(AmsUser user);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);



}
