package com.joker.ams.service.impl;

import com.joker.ams.common.ResultVo;
import com.joker.ams.dao.AmsRoleDao;
import com.joker.ams.entity.AmsRole;
import com.joker.ams.service.AmsRoleService;
import com.joker.ams.utils.RedisCache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 角色表(AmsRole)表服务实现类
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
@Service("amsRoleService")
public class AmsRoleServiceImpl implements AmsRoleService {
    @Resource
    private AmsRoleDao roleDao;


    @Resource
    RedisCache redisCache;



    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public ResultVo getRoleList(Integer page, Integer size) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("roles", roleDao.getRoleListByCurrent((page - 1) * size, size));
        map.put("totalCount", roleDao.getRoleCount());
        return new ResultVo(200, "success", map);
    }

    @Override
    public ResultVo getRoles() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles", roleDao.getRoleList());
        return new ResultVo(200, "success", map);
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AmsRole queryById(Long id) {
        return this.roleDao.queryById(id);
    }

    @Override
    public Page<AmsRole> queryByPage(AmsRole amsRole, PageRequest pageRequest) {
        return null;
    }


    /**
     * 新增数据
     *
     * @param amsRole 实例对象
     * @return 实例对象
     */
    @Override
    public AmsRole insert(AmsRole amsRole) {
        this.roleDao.insert(amsRole);
        return amsRole;
    }

    /**
     * 修改数据
     *
     * @param amsRole 实例对象
     * @return 实例对象
     */
    @Override
    public AmsRole update(AmsRole amsRole) {
        this.roleDao.update(amsRole);
        return this.queryById(amsRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.roleDao.deleteById(id) > 0;
    }

}
