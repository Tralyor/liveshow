package org.liveshow.controller;

import org.liveshow.entity.User;
import org.liveshow.service.UserService;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

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
