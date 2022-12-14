package com.joker.ams.dao;

import com.joker.ams.entity.AmsUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (AmsUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
public interface AmsUserRoleDao {

    /**
     * 新增用户角色关系
     *
     * @param amsUserRole 实例对象
     * @return 影响行数
     */
    int insert(AmsUserRole amsUserRole);












    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    AmsUserRole queryById(Long userId);

    /**
     * 查询指定行数据
     *
     * @param amsUserRole 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<AmsUserRole> queryAllByLimit(AmsUserRole amsUserRole, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param amsUserRole 查询条件
     * @return 总行数
     */
    long count(AmsUserRole amsUserRole);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsUserRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AmsUserRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsUserRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AmsUserRole> entities);

    /**
     * 修改数据
     *
     * @param amsUserRole 实例对象
     * @return 影响行数
     */
    int update(AmsUserRole amsUserRole);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);

}

