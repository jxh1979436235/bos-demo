package com.xr.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysUser implements Serializable {
    private Long id;

    private String name;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Byte status;

    private Long deptId;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;

    private String introduction;

    private String avatar;

    private static final long serialVersionUID = 1L;
}