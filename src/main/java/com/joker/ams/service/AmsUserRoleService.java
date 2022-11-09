package com.joker.ams.service;

import com.joker.ams.entity.AmsUserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (AmsUserRole)表服务接口
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
public interface AmsUserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    AmsUserRole queryById(Long userId);

    /**
     * 分页查询
     *
     * @param amsUserRole 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<AmsUserRole> queryByPage(AmsUserRole amsUserRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param amsUserRole 实例对象
     * @return 实例对象
     */
    AmsUserRole insert(AmsUserRole amsUserRole);

    /**
     * 修改数据
     *
     * @param amsUserRole 实例对象
     * @return 实例对象
     */
    AmsUserRole update(AmsUserRole amsUserRole);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

}
