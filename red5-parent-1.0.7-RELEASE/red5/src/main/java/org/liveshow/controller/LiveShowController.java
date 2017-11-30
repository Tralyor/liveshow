package org.liveshow.controller;

import org.liveshow.entity.Room;
import org.liveshow.service.RoomService;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Cjn on 2017/11/30.
 */
@Controller
@RequestMapping("/liveShow")
public class LiveShowController {
    @Autowired
    private RoomService roomService;
    
    @RequestMapping("/index")
    public String indexPage(int roomId,Model model){
        Room room = roomService.findRoomById(roomId);
        if (room == null){
            return null;
        }
        model.addAttribute("room",room);
        RoomPopularity  roomPopularity  = RoomPopularity.getInstance();
        model.addAttribute("roomPopularity",roomPopularity);
        
        return "show/liveShow";
    }
    
    @RequestMapping("/addCare")
    public void addCare(){
        
    }
}
