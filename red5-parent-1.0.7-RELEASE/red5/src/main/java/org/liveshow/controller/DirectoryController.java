package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.CombinationEntity.RecommendModulAndInfo;
import org.liveshow.entity.CombinationEntity.RoomAndOwner;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.service.ModuleService;
import org.liveshow.service.PartService;
import org.liveshow.service.RecommendModuleService;
import org.liveshow.service.RoomService;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * Created by Cjn on 2017/11/29.
 */
@Controller
@RequestMapping("/directory")
public class DirectoryController {
    
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private PartService partService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private RecommendModuleService recommendModuleService;
    
    @RequestMapping("/part")
    public String findAllPart(Model model){
        List<RecommendModulAndInfo> modules = recommendModuleService.findRecoModul();
        List<Module> allModules =  moduleService.findModuleByPartId(0);
        List<Part> parts = partService.findAllPart();
        model.addAttribute("modules",modules);
        model.addAttribute("allModules",allModules);
        model.addAttribute("parts",parts);
        return "show/directory";
    }
    
    @RequestMapping("/partClass")
    @ResponseBody
    public List<Module> partClass(int typeNum){
        List<Module> lists = moduleService.findModuleByPartId(typeNum);
        return lists;
    }
    
    @RequestMapping("/module/{moduleId}")
    public String videoDirectory(@PathVariable int moduleId , Model model){
        List<RoomAndOwner> room = roomService.findRecoRoom(moduleId,0,20);
        RoomPopularity roomPopularity = RoomPopularity.getInstance();
        List<RecommendModulAndInfo> modules = recommendModuleService.findRecoModul();
        List<Module> allModules =  moduleService.findModuleByPartId(0);
        List<Part> parts = partService.findAllPart();

        Module module = moduleService.findModuleById(moduleId);

        model.addAttribute("module",module);
        model.addAttribute("modules",modules);
        model.addAttribute("allModules",allModules);
        model.addAttribute("parts",parts);
        model.addAttribute("room",room);
        model.addAttribute("roomPopularity",roomPopularity);
        return "show/videoDirectory";
    }
    
    @RequestMapping("/video/page")
    @ResponseBody
    public Show videoDirectory(int moduleId , int pageNo, int pageSize){
        List<RoomAndOwner> room = roomService.findRecoRoom(moduleId,pageNo,pageSize);
        Show show = new Show();
        if (room ==null){
            show.setState(0);
            show.setMessage("已经没有直播间了");
        }else{
            show.setData(room);
            show.setState(1);
            show.setMessage("请求成功");
            
        }
        return show;
    }
    
}
