package com.xr.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysMenu implements Serializable {
    private Long id;

    private String name;

    private Long parentId;

    private String url;

    private String perms;

    private Integer type;

    private String icon;

    private Integer orderNum;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;

    private static final long serialVersionUID = 1L;


}