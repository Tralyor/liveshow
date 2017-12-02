package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.entity.Room;
import org.liveshow.service.*;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cjn on 2017/11/30.
 */
@Controller
@RequestMapping("/liveShow")
public class LiveShowController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private CareService careService;
    @Autowired
    private PartService partService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private DarkroomDanmakuService darkroomDanmakuService;
    
    @RequestMapping("/index")
    public String indexPage(int roomId,@RequestParam(value = "userId",required = false,defaultValue = "0") int userId,Model model){
        Room room = roomService.findRoomById(roomId);
        if (room == null){
            return "404";
        }
        int careNum = careService.careNum(roomId);
        int isCare = 1;
        int isDark = 0;
        if (userId != 0){
            isCare = careService.isCare(userId,roomId);
            isDark = darkroomDanmakuService.isDark(userId, roomId);   
        }
        Module module =  moduleService.findModuleById(room.getModuleId());
        Part part = partService.findPartById(module.getPartId());
        model.addAttribute("module",module);
        model.addAttribute("part",part);
        model.addAttribute("room",room);
        model.addAttribute("careNum",careNum);
        model.addAttribute("isCare",isCare);
        model.addAttribute("isDark",isDark);
        RoomPopularity  roomPopularity  = RoomPopularity.getInstance();
        roomPopularity.getRoomIdAndPopularity().get(roomId).addpopulartyNow();
        roomPopularity.getRoomIdAndPopularity().get(roomId).setMaxPopulation();
        model.addAttribute("onlinePeople",roomPopularity.getRoomIdAndPopularity().get(roomId).getPopulartyNow());
        return "show/liveShow";
    }

    /**
     * @Author Cjn
     * @param roomId
     * @param userId
     * @return
     * 添加关注接口
     */
    @RequestMapping("/addCare")
    @ResponseBody
    public Show addCare(int roomId,int userId){
        Show show = new Show();
        if (roomId == 0 || userId ==0){
           show.setMessage("参数错误");
           show.setState(0);
        }else{
          int res = careService.addCare(roomId,userId);
          if (res == 0 ){
              show.setState(0);
              show.setMessage("插入操作失败0");
          }else{
              show.setState(1);
              show.setMessage("关注成功");
          }
        }
        return show;
    }

    /**
     * @Author Cjn
     * @param roomId
     * @param userId
     * @return
     * 添加关注接口
     */
    @RequestMapping("/deleteCare")
    @ResponseBody
    public Show deleteCare(int roomId,int userId){
        Show show = new Show();
        if (roomId == 0 || userId ==0){
            show.setMessage("参数错误");
            show.setState(0);
        }else{
            int res = careService.deleteCare(userId,roomId);
            if (res == 0 ){
                show.setState(0);
                show.setMessage("取消关注失败");
            }else{
                show.setState(1);
                show.setMessage("取消成功");
            }
        }
        return show;
    }
    
    @RequestMapping("/leave")
    public void leavePage(int roomId){
        RoomPopularity.getInstance().getRoomIdAndPopularity().get(roomId).deletepopulartyNow();
        return ;
    }
}
