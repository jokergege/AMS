package com.joker.ams.service.impl;

import com.joker.ams.entity.AmsRoleMenu;
import com.joker.ams.dao.AmsRoleMenuDao;
import com.joker.ams.service.AmsRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (AmsRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
@Service("amsRoleMenuService")
public class AmsRoleMenuServiceImpl implements AmsRoleMenuService {
    @Resource
    private AmsRoleMenuDao amsRoleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public AmsRoleMenu queryById(Long roleId) {
        return this.amsRoleMenuDao.queryById(roleId);
    }

    /**
     * 分页查询
     *
     * @param amsRoleMenu 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<AmsRoleMenu> queryByPage(AmsRoleMenu amsRoleMenu, PageRequest pageRequest) {
        long total = this.amsRoleMenuDao.count(amsRoleMenu);
        return new PageImpl<>(this.amsRoleMenuDao.queryAllByLimit(amsRoleMenu, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param amsRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public AmsRoleMenu insert(AmsRoleMenu amsRoleMenu) {
        this.amsRoleMenuDao.insert(amsRoleMenu);
        return amsRoleMenu;
    }

    /**
     * 修改数据
     *
     * @param amsRoleMenu 实例对象
     * @return 实例对象
     */
    @Override
    public AmsRoleMenu update(AmsRoleMenu amsRoleMenu) {
        this.amsRoleMenuDao.update(amsRoleMenu);
        return this.queryById(amsRoleMenu.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long roleId) {
        return this.amsRoleMenuDao.deleteById(roleId) > 0;
    }
}
