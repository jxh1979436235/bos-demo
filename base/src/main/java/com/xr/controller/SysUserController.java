package com.xr.controller;

import com.xr.entity.SysUser;
import com.xr.service.SysUserService;
import com.xr.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 验证登录
     * @param sysUser 把用户名和密码封装成对象形式
     * @return 账号是否存在
     */
    @RequestMapping("login")
    public ResponseResult login( SysUser sysUser){
        SysUser loginUser=sysUserService.login(sysUser);
        ResponseResult result=new ResponseResult();
        if(loginUser==null){
            result.getData().put("message","账号或密码错误");
        }else{
            result.getData().put("token",loginUser.getId());
        }
        return result;
    }

    /**
     * 根据 用户id查询用户以及对应的角色
     * @param token
     * @return
     */
    @RequestMapping("info")
    public  ResponseResult info(Integer token){
        //根据用户ID获取用户信息
        SysUser sysUser=sysUserService.selectById(token);
        //根据用户ID获取角色名
        List<String> roles =  sysUserService.findUserRoles(token);
        ResponseResult result = new ResponseResult();
        result.getData().put("roles",roles);
        result.getData().put("introduction",sysUser.getIntroduction());
        result.getData().put("avatar",sysUser.getAvatar());
        result.getData().put("name",sysUser.getName());
        return result;
    }
    /**
     * 查询所有用户
     */
    @RequestMapping("list")
    public ResponseResult getList(String name, Integer page, Integer limit){
     Map map= sysUserService.getList(name,page,limit);
      ResponseResult result=new ResponseResult();
        result.getData().putAll(map);
      return result;
    }

    /**
     * 添加用户
     *
     */
    @RequestMapping("add")
    public ResponseResult  insert(SysUser user){
        SysUser sysUser=sysUserService.selectById(Integer.valueOf(user.getCreateBy()));
        user.setStatus((byte) 1);
        user.setCreateBy(sysUser.getName());
        user.setCreateTime(new Date());
        sysUserService.insert(user);
        return new ResponseResult();
    }

    /**
     * 修改用户
     */
    @RequestMapping("update")
    public ResponseResult update( SysUser user){
        if(user!=null){
            SysUser sysUser=sysUserService.selectById(Integer.valueOf(user.getLastUpdateBy()));
            user.setLastUpdateBy(sysUser.getName());
            user.setLastUpdateTime(new Date());
            sysUserService.update(user);
        }
        return new ResponseResult();
    }

    /**
     * 删除用户
     */
    @RequestMapping("delete")
    public ResponseResult delete(Integer id){
        sysUserService.delete(id);
        return new ResponseResult();
    }

    @org.springframework.web.bind.annotation.InitBinder
    public void InitBinder(WebDataBinder binder, WebRequest request)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        CustomDateEditor editor = new CustomDateEditor(df,true);//参数为true表示允许为空值
        binder.registerCustomEditor(Date.class, editor);
    }
}
