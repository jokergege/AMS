package com.joker.ams.service.impl;

import com.joker.ams.entity.AmsUserRole;
import com.joker.ams.dao.AmsUserRoleDao;
import com.joker.ams.service.AmsUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (AmsUserRole)表服务实现类
 *
 * @author makejava
 * @since 2022-10-12 20:32:38
 */
@Service("amsUserRoleService")
public class AmsUserRoleServiceImpl implements AmsUserRoleService {
    @Resource
    private AmsUserRoleDao amsUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public AmsUserRole queryById(Long userId) {
        return this.amsUserRoleDao.queryById(userId);
    }

    /**
     * 分页查询
     *
     * @param amsUserRole 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<AmsUserRole> queryByPage(AmsUserRole amsUserRole, PageRequest pageRequest) {
        long total = this.amsUserRoleDao.count(amsUserRole);
        return new PageImpl<>(this.amsUserRoleDao.queryAllByLimit(amsUserRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param amsUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public AmsUserRole insert(AmsUserRole amsUserRole) {
        this.amsUserRoleDao.insert(amsUserRole);
        return amsUserRole;
    }

    /**
     * 修改数据
     *
     * @param amsUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public AmsUserRole update(AmsUserRole amsUserRole) {
        this.amsUserRoleDao.update(amsUserRole);
        return this.queryById(amsUserRole.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.amsUserRoleDao.deleteById(userId) > 0;
    }
}
