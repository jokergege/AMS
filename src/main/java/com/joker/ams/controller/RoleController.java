package com.joker.ams.controller;

import com.joker.ams.common.ResultVo;
import com.joker.ams.entity.AmsRole;
import com.joker.ams.service.AmsRoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("role")
@CrossOrigin
public class RoleController {
    @Resource
    AmsRoleService roleService;

    @PreAuthorize("hasAnyAuthority('role:list')")
    @GetMapping("getRolesByCurrent")
    public ResultVo getRoleByCurrent(Integer page, Integer size) {
        return roleService.getRoleList(page, size);
    }

    @GetMapping("getRoles")
    public ResultVo getRoles() {
        return roleService.getRoles();
    }


    /**
     * 添加角色
     *
     * @return
     */
    @PostMapping(value = "/add")
    public ResultVo addRole(@RequestBody AmsRole role) {
        return null;
    }

}
