package org.liveshow.controller;

import org.liveshow.dto.Show;
import org.liveshow.service.LiveRecordService;
import org.liveshow.service.RoomService;
import org.red5.server.messaging.IFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Cjn on 2017/12/1.
 */
@Controller
@RequestMapping("/anchor")
public class AnchorController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private LiveRecordService liveRecordService;
    
    @ResponseBody
    @RequestMapping("/change")
    public Show changeShowState(int roomId,int state){
        Show show = new Show();
        roomService.changeRoomState(roomId,state);
        if (state == 1){
            liveRecordService.addRecord(roomId);
        }else{
            liveRecordService.finishRecord(roomId);
        }
        show.setState(1);
        show.setMessage("操作成功");
        return show;
    }
}
