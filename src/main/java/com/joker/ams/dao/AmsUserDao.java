package com.joker.ams.dao;

import com.joker.ams.entity.AmsUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户表(AmsUser)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
public interface AmsUserDao {
    /**
     * 按名字查询
     * @param username
     * @return
     */
    AmsUser queryUserByName(String username);

    /**
     * 新增数据
     *
     * @param amsUser 实例对象
     * @return userId
     */
    Long insert(AmsUser amsUser);


    /**
     * 分页查询
     * @param start
     * @param size
     * @return
     */
    List<AmsUser> getUserList(@Param("start") Integer start, @Param("size") Integer size);
    Integer getUserCount();

    /**
     * 根据手机号查用户
     * @param phoneNumber
     * @return
     */
    AmsUser queryUserByPhone(String phoneNumber);

    /**
     * 根据用户名更改密码
     * @param password
     * @param userName
     * @return
     */
    int updatePassword(@Param("password") String password, @Param("userName") String userName);






    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AmsUser queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param amsUser  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<AmsUser> queryAllByLimit(AmsUser amsUser, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param amsUser 查询条件
     * @return 总行数
     */
    long count(AmsUser amsUser);



    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AmsUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AmsUser> entities);

    /**
     * 修改数据
     *
     * @param amsUser 实例对象
     * @return 影响行数
     */
    int update(AmsUser amsUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);



}

