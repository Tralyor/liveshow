package org.liveshow.controller;

import org.liveshow.entity.User;
import org.liveshow.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hp on 2017/11/7.
 */
@Controller
@RequestMapping("ac")
public class UserController {
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @RequestMapping("hello")
    public List<User> Hello(){
        return userService.users();
    }
    
}
