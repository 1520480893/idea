package com.test.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
@RequiresRoles("管理员")
public class AdminController {
    @RequestMapping("/toAddUser")
    @RequiresPermissions("用户新增")
    public String toAddUser(){
        return "admin/addUser";
    }
}
