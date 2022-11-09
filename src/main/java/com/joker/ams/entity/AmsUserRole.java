package com.joker.ams.entity;

import java.io.Serializable;

/**
 * (AmsUserRole)实体类
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
public class AmsUserRole implements Serializable {
    private static final long serialVersionUID = 841766230509866577L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 角色id
     */
    private Long roleId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}

