package org.liveshow.controller;

import org.liveshow.entity.Module;
import org.liveshow.entity.Room;
import org.liveshow.service.RecommendHomeService;
import org.liveshow.service.RecommendModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
/**
 * Created by Cjn on 2017/11/28.
 */
@Controller
public class IndexController {
    @Autowired
    private RecommendHomeService recommendHomeService;
    @Autowired
    private RecommendModuleService recommendModuleService;
    
    @RequestMapping("/index")
    public String getIndex(Model model){
       List<Room> recoRoom =  recommendHomeService.findAllRecHome();
       List<Module> modules = recommendModuleService.findRecoModul();
       return "show/index";
    }
}
