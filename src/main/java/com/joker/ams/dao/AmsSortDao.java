package com.joker.ams.dao;

import com.joker.ams.entity.AmsSort;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (AmsSort)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
public interface AmsSortDao {

    List<AmsSort> queryAllSort();









    /**
     * 通过ID查询单条数据
     *
     * @param sortId 主键
     * @return 实例对象
     */
    AmsSort queryById(Integer sortId);

    /**
     * 查询指定行数据
     *
     * @param amsSort  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<AmsSort> queryAllByLimit(AmsSort amsSort, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param amsSort 查询条件
     * @return 总行数
     */
    long count(AmsSort amsSort);

    /**
     * 新增数据
     *
     * @param amsSort 实例对象
     * @return 影响行数
     */
    int insert(AmsSort amsSort);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsSort> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AmsSort> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AmsSort> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AmsSort> entities);

    /**
     * 修改数据
     *
     * @param amsSort 实例对象
     * @return 影响行数
     */
    int update(AmsSort amsSort);

    /**
     * 通过主键删除数据
     *
     * @param sortId 主键
     * @return 影响行数
     */
    int deleteById(Integer sortId);


    List<AmsSort> getSortListByCurrent(@Param("start") int start, @Param("size") Integer size);

    Integer getSortCount();
}

