package com.joker.ams.service;

import com.joker.ams.entity.AmsRoleMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (AmsRoleMenu)表服务接口
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
public interface AmsRoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    AmsRoleMenu queryById(Long roleId);

    /**
     * 分页查询
     *
     * @param amsRoleMenu 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<AmsRoleMenu> queryByPage(AmsRoleMenu amsRoleMenu, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param amsRoleMenu 实例对象
     * @return 实例对象
     */
    AmsRoleMenu insert(AmsRoleMenu amsRoleMenu);

    /**
     * 修改数据
     *
     * @param amsRoleMenu 实例对象
     * @return 实例对象
     */
    AmsRoleMenu update(AmsRoleMenu amsRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Long roleId);

}
