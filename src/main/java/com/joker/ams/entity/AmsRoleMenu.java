package com.joker.ams.entity;

import java.io.Serializable;

/**
 * (AmsRoleMenu)实体类
 *
 * @author makejava
 * @since 2022-10-12 20:32:36
 */
public class AmsRoleMenu implements Serializable {
    private static final long serialVersionUID = 732386944525277958L;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单id
     */
    private Long menuId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

}

