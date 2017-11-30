package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.entity.Room;
import org.liveshow.service.ModuleService;
import org.liveshow.service.PartService;
import org.liveshow.service.RoomService;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    @RequestMapping("/part")
    public String findAllPart(Model model){
        List<Module> modules =  moduleService.findModuleByPartId(0);
        List<Part> parts = partService.findAllPart();
        model.addAttribute("modules",modules);
        model.addAttribute("parts",parts);
        return "show/directory";
    }
    
    @RequestMapping("/partClass")
    @ResponseBody
    public List<Module> partClass(int typeNum){
        List<Module> lists = moduleService.findModuleByPartId(typeNum);
        return lists;
    }
    
    @RequestMapping("/module/part")
    public String videoDirectory(int moduleId ,Model model){
        List<Room> room = roomService.findRecoRoom(moduleId,0,4);
        RoomPopularity roomPopularity = RoomPopularity.getInstance();
        model.addAttribute("room",room);
        model.addAttribute("roomPopularity",roomPopularity);
        return "show/videoDirectory";
    }
    
    @RequestMapping("/video/page")
    @ResponseBody
    public Show videoDirectory(int moduleId , int pageNo, int pageSize){
        List<Room> room = roomService.findRecoRoom(moduleId,pageNo,pageSize);
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
