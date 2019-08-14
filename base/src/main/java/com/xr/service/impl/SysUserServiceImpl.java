package com.xr.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xr.entity.SysUser;
import com.xr.entity.SysUserExample;
import com.xr.mapper.SysUserMapper;
import com.xr.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sysUserService")
public class  SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysUser sysUser) {
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria=example.createCriteria();
        criteria.andNameEqualTo(sysUser.getName());
        criteria.andPasswordEqualTo(sysUser.getPassword());
        List<SysUser> list= sysUserMapper.selectByExample(example);
        if (list!=null&&list.size()==1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public SysUser selectById(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<String> findUserRoles( Integer id) {
        return sysUserMapper.findUserRoles(id);

    }

    @Override
    public Map getList(String name, Integer page, Integer limit) {
        SysUserExample example=new SysUserExample();
        SysUserExample.Criteria criteria=example.createCriteria();
        criteria.andDelFlagEqualTo((byte) 0);
        if(name!=null&&name!=""){
            criteria.andNameLike("%"+name+"%");
        }
        PageHelper pageHelper=new PageHelper();
        Page p=pageHelper.startPage(page,limit,true);
        Map<String,Object> map=new HashMap<>();
      sysUserMapper.selectByExample(example);
        map.put("items",p.getResult());
        map.put("total",p.getTotal());
        return map;
    }

    @Override
    public void insert(SysUser sysUser) {
        sysUserMapper.insertSelective(sysUser);
    }

    @Override
    public void update(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public void delete(long id) {
      SysUser sysUser= sysUserMapper.selectByPrimaryKey(id);
        sysUser.setDelFlag((byte) -1);
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }
}
