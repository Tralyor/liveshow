package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.entity.Danmaku;
import org.liveshow.entity.DarkroomDanmaku;
import org.liveshow.service.DanmakuService;
import org.liveshow.service.DarkroomDanmakuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cjn on 2017/12/1.
 */

@Controller
@RequestMapping("/danmaku")
public class DanmakuController {
    
    @Autowired
    private DanmakuService danmakuService;
    @Autowired
    private DarkroomDanmakuService darkroomDanmakuService;
    
    @RequestMapping("/add")
    @ResponseBody
    public Show addDanmaku(int userId,int roomId,String content){
        Show show = new Show();
        int res = danmakuService.addDanmaku(userId,roomId,content);
        show.setState(res);
        show.setMessage("添加成功");
        return show;
    }
    
    @RequestMapping("/addDarkDanmaku")
    public Show addDarkRoom(int danmakuId,int hour){
        Show show = new Show();
        DarkroomDanmaku darkroomDanmaku = new DarkroomDanmaku();
        darkroomDanmaku.setDanmakuId(danmakuId);
        darkroomDanmaku.setHours(hour);
        darkroomDanmaku.setTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
        int res = darkroomDanmakuService.addDarkRoomDanmaku(darkroomDanmaku);
       show.setState(res);
        return show;
    }
}
