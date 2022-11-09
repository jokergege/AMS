package com.joker.ams.entity;

import java.io.Serializable;

/**
 * (AmsSort)实体类
 *
 * @author makejava
 * @since 2022-10-12 20:32:37
 */
public class AmsSort implements Serializable {
    private static final long serialVersionUID = -53231934223368182L;

    private Integer sortId;

    private String sortName;


    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

}

