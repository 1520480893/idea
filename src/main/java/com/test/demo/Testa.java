package com.test.demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class Testa {
    public static void main(String[] args) {
        IniSecurityManagerFactory ini = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = ini.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                "zs","1233"
        );
        try {
            subject.login(usernamePasswordToken);
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
        }catch (UnknownAccountException e){
            System.out.println("用户名不存在");
        }
    }
}
