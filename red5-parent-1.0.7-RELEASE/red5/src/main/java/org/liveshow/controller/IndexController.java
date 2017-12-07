package org.liveshow.controller;

import org.liveshow.entity.CombinationEntity.RecommendModulAndInfo;
import org.liveshow.entity.CombinationEntity.RoomAndOwner;
import org.liveshow.entity.Room;
import org.liveshow.service.RecommendHomeService;
import org.liveshow.service.RecommendModuleService;
import org.liveshow.service.RoomService;
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
    @Autowired
    private RoomService roomService;
    
    @RequestMapping("/index")
    public String getIndex(Model model){
       List<Room> recoRoom =  recommendHomeService.findAllRecHome();
       List<RecommendModulAndInfo> modules = recommendModuleService.findRecoModul();
       List<RoomAndOwner> reco1 = roomService.findRecoRoom(modules.get(0).getId(),0,4);
       List<RoomAndOwner> reco2 = roomService.findRecoRoom(modules.get(1).getId(),0,4);
       List<RoomAndOwner> reco3 = roomService.findRecoRoom(modules.get(2).getId(),0,4);
       model.addAttribute("recoRoom",recoRoom);
       model.addAttribute("modules",modules);
       model.addAttribute("reco1",reco1);
       model.addAttribute("reco2",reco2);
       model.addAttribute("reco3",reco3);
       return "show/index";
    }
}
