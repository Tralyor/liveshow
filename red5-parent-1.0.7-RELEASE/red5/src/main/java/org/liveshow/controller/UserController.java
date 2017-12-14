package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.User;
import org.liveshow.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by hp on 2017/11/7.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
   @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String loginPage(){
       return "show/login";
   }
   
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public Show doLogin(String loginName ,String password,HttpServletRequest req){
        Show show  = new Show();
        User user = userService.doLogin(loginName,password);
        if (user == null){
            show.setState(0);
            show.setMessage("用户名密码错误");
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            show.setState(1);
            show.setMessage("登陆成功");
        }
        return show;
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "show/register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public Show doRegister(String loginName, String password, String nickName){
        return userService.doRegister(loginName,password,nickName);
    }

}
