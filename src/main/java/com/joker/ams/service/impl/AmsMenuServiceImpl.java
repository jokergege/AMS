package com.joker.ams.service.impl;

import com.joker.ams.entity.AmsMenu;
import com.joker.ams.dao.AmsMenuDao;
import com.joker.ams.service.AmsMenuService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 菜单表(AmsMenu)表服务实现类
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
@Service("amsMenuService")
public class AmsMenuServiceImpl implements AmsMenuService {
    @Resource
    private AmsMenuDao amsMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AmsMenu queryById(Long id) {
        return this.amsMenuDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param amsMenu     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<AmsMenu> queryByPage(AmsMenu amsMenu, PageRequest pageRequest) {
        long total = this.amsMenuDao.count(amsMenu);
        return new PageImpl<>(this.amsMenuDao.queryAllByLimit(amsMenu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param amsMenu 实例对象
     * @return 实例对象
     */
    @Override
    public AmsMenu insert(AmsMenu amsMenu) {
        this.amsMenuDao.insert(amsMenu);
        return amsMenu;
    }

    /**
     * 修改数据
     *
     * @param amsMenu 实例对象
     * @return 实例对象
     */
    @Override
    public AmsMenu update(AmsMenu amsMenu) {
        this.amsMenuDao.update(amsMenu);
        return this.queryById(amsMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.amsMenuDao.deleteById(id) > 0;
    }
}
