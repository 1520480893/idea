package com.test.controller;

import com.test.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/toLogin")
    public String toLogin(){
       return "login";
    }
    @RequestMapping("/doLogin")
    public String doLogin(User user, HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getUsername(), user.getPassword()
        );
        try {
            subject.login(usernamePasswordToken);
            session.setAttribute("username",user.getUsername());
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
        }catch (UnknownAccountException e){
            System.out.println("用户名不存在");
        }

        return "main";
    }
}
