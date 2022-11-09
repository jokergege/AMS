package com.joker.ams.dao;

import com.joker.ams.entity.AmsMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 菜单表(AmsMenu)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
public interface AmsMenuDao {



    List<String> selectPermsByUserId(Long userId);



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AmsMenu queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param amsMenu  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<AmsMenu> queryAllByLimit(AmsMenu amsMenu, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param amsMenu 查询条件
     * @return 总行数
     */
    long count(AmsMenu amsMenu);

    /**
     * 新增数据
     *
     * @param amsMenu 实例对象
     * @return 影响行数
     */
    int insert(AmsMenu amsMenu);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsMenu> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AmsMenu> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsMenu> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AmsMenu> entities);

    /**
     * 修改数据
     *
     * @param amsMenu 实例对象
     * @return 影响行数
     */
    int update(AmsMenu amsMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

