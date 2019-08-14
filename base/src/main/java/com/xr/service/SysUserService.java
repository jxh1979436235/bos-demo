package com.xr.service;

import com.xr.entity.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserService {

    // 登录验证
    public SysUser login(SysUser sysUser);

    //根据用户id获取用户信息
    public SysUser selectById(Integer id);

    //根据用户ID查询角色名
    public List<String> findUserRoles(Integer id);

    //查询所有用户
    public Map getList(String name, Integer page, Integer limit);

    //添加用户
    public void insert(SysUser sysUser);

    //修改用户
    public void update(SysUser sysUser);

    //删除用户
    public void delete(long id);
}
