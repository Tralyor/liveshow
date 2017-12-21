package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.CombinationEntity.RecommendModulAndInfo;
import org.liveshow.entity.CombinationEntity.RoomAndOwner;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.entity.User;
import org.liveshow.service.*;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @Autowired
    private RecommendModuleService recommendModuleService;
    @Autowired
    private DarkroomRoomService darkroomRoomService;
    
    @RequestMapping("/index/{roomId}") 
    public String indexPage(@PathVariable("roomId") int roomId, HttpServletRequest req, Model model){
        RoomAndOwner room = roomService.findRoomByIdWidhtOnwer(roomId);
        if (room == null){
            return "404";
        }
        HttpSession session = req.getSession();
        int careNum = careService.careNum(roomId);
        int isDarkRoom = darkroomRoomService.isDrakRoom(roomId);
        int isCare = 0;
        int isDark = 0;
        int userId;
        if (session.getAttribute("user") != null){
            User user = (User)session.getAttribute("user");
            userId = user.getId();
            isCare = careService.isCare(userId,roomId);
            isDark = darkroomDanmakuService.isDark(userId, roomId);
        }
        Module itsModule =  moduleService.findModuleById(room.getModuleId());
        Part itsPart = partService.findPartById(itsModule.getPartId());
        List<RecommendModulAndInfo> modules = recommendModuleService.findRecoModul();
        List<Module> allModules =  moduleService.findModuleByPartId(0);
        List<Part> parts = partService.findAllPart();
        model.addAttribute("isDarkRoom",isDarkRoom);
        model.addAttribute("modules",modules);
        model.addAttribute("allModules",allModules);
        model.addAttribute("parts",parts);
        model.addAttribute("module",itsModule);
        model.addAttribute("part",itsPart);
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
    public Show addCare(int roomId,HttpServletRequest req){
        Show show = new Show();
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null){
           show.setMessage("请先登录");
           show.setState(0);
        }else{
          User user =  (User)session.getAttribute("user");
          int userId = user.getId();
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
     * @return
     * 添加关注接口
     */
    @RequestMapping("/deleteCare")
    @ResponseBody
    public Show deleteCare(int roomId,HttpServletRequest req){
        Show show = new Show();
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null){
            show.setMessage("请先登录");
            show.setState(0);
        }else{
            User user =  (User)session.getAttribute("user");
            int userId = user.getId();
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
