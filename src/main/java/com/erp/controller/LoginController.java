package com.erp.controller;

import com.erp.pojo.Emp;
import com.erp.util.TreeResultUtil;
import com.erp.service.EmpService;
import com.erp.util.TreeResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @RequestMapping("login")
    @ResponseBody
    public boolean login(String username, String password, HttpSession session){
        Emp emp = empService.login(username,password);
        if (emp!=null){
            session.setAttribute("user",emp);
            return true;
        }else{
            //登录失败 转发给login.html
            return false;
        }
    }

    @RequestMapping("isLogin")
    @ResponseBody
    public String isLogin(HttpSession session){
        Object user = session.getAttribute("user");
        if(user!=null){
            Emp emp = (Emp)user;
            return emp.getUsername();
        }
        return null;
    }

    @RequestMapping("logout")
    public String logout(HttpSession session){
        session.invalidate();
        //重定向回首页
        return "redirect:/";
    }

    @RequestMapping("getPerms")
    @ResponseBody
    public List<TreeResultUtil> getPerms(String username){
        return empService.getPerms(username);
    }
}
