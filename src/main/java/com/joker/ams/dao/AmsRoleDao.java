package com.joker.ams.dao;

import com.joker.ams.entity.AmsRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表(AmsRole)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
public interface AmsRoleDao {

    /**
     * 分页查询
     * @param start
     * @param size
     * @return
     */
    List<AmsRole> getRoleListByCurrent(@Param("start") Integer start, @Param("size") Integer size);


    /**
     * 查询记录总数
     * @return
     */
    Integer getRoleCount();



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AmsRole queryById(Long id);







    /**
     * 统计总行数
     *
     * @param amsRole 查询条件
     * @return 总行数
     */
    long count(AmsRole amsRole);

    /**
     * 新增数据
     *
     * @param amsRole 实例对象
     * @return 影响行数
     */
    int insert(AmsRole amsRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AmsRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AmsRole> entities);

    /**
     * 修改数据
     *
     * @param amsRole 实例对象
     * @return 影响行数
     */
    int update(AmsRole amsRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);


    List<AmsRole>  getRoleList();
}

