package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.entity.RecommendModule;
import org.liveshow.service.ModuleService;
import org.liveshow.service.PartService;
import org.liveshow.service.RecommendModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Zzzz on 2017/11/29.
 */
@Controller
@RequestMapping("/recommend")
public class RecommendModuleController {

    @Autowired
    private RecommendModuleService recommendModuleService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private PartService partService;

    @RequestMapping(value = "/handleInfo",method = RequestMethod.POST)
    @ResponseBody
    public Show handleInfo(@RequestParam("id") int id, @RequestParam("moduleId") String moduleId){
        return recommendModuleService.handleRecommendModule(id, moduleId);
    }

    @RequestMapping("/getPartAndModule")
    @ResponseBody
    public Show getPartAndModule(){
        return moduleService.getModuleAndPart();
    }

    @RequestMapping("/presentModule")
    @ResponseBody
    public Show getPresent(Model model){
        return recommendModuleService.getAllRecommendModule();
    }

}
