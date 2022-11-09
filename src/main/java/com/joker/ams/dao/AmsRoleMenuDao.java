package com.joker.ams.dao;

import com.joker.ams.entity.AmsRoleMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (AmsRoleMenu)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
public interface AmsRoleMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    AmsRoleMenu queryById(Long roleId);

    /**
     * 查询指定行数据
     *
     * @param amsRoleMenu 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<AmsRoleMenu> queryAllByLimit(AmsRoleMenu amsRoleMenu, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param amsRoleMenu 查询条件
     * @return 总行数
     */
    long count(AmsRoleMenu amsRoleMenu);

    /**
     * 新增数据
     *
     * @param amsRoleMenu 实例对象
     * @return 影响行数
     */
    int insert(AmsRoleMenu amsRoleMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsRoleMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AmsRoleMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsRoleMenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AmsRoleMenu> entities);

    /**
     * 修改数据
     *
     * @param amsRoleMenu 实例对象
     * @return 影响行数
     */
    int update(AmsRoleMenu amsRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    int deleteById(Long roleId);

}

