package com.xr.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysRole implements Serializable {
    private Long id;

    private String name;

    private String remark;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;

    private static final long serialVersionUID = 1L;


}