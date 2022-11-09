package com.joker.ams.service;

import com.joker.ams.entity.AmsMenu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 菜单表(AmsMenu)表服务接口
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
public interface AmsMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AmsMenu queryById(Long id);

    /**
     * 分页查询
     *
     * @param amsMenu     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<AmsMenu> queryByPage(AmsMenu amsMenu, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param amsMenu 实例对象
     * @return 实例对象
     */
    AmsMenu insert(AmsMenu amsMenu);

    /**
     * 修改数据
     *
     * @param amsMenu 实例对象
     * @return 实例对象
     */
    AmsMenu update(AmsMenu amsMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
