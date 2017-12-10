package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.Part;
import org.liveshow.service.PartService;
import org.liveshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Zzzz on 2017/12/3.
 */

@Controller
@RequestMapping("/overview")
public class OverviewController {

    @Autowired
    private UserService userService;


    @RequestMapping("/charts")
    public String getView(){
         return "manager/overview";
    }

    @RequestMapping("/chartsinfo")
    @ResponseBody
    public Show getChartsInfo(){

        Show show = userService.overviewInfo();
        return show;
    }

}
