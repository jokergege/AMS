package com.joker.ams.service;

import com.joker.ams.common.ResultVo;
import com.joker.ams.entity.AmsRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色表(AmsRole)表服务接口
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
public interface AmsRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AmsRole queryById(Long id);

    /**
     * 分页查询
     *
     * @param amsRole     筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<AmsRole> queryByPage(AmsRole amsRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param amsRole 实例对象
     * @return 实例对象
     */
    AmsRole insert(AmsRole amsRole);

    /**
     * 修改数据
     *
     * @param amsRole 实例对象
     * @return 实例对象
     */
    AmsRole update(AmsRole amsRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    ResultVo getRoleList(Integer page, Integer size);

    ResultVo getRoles();

}
