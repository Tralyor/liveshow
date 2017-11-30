package org.liveshow.service.impl;

import org.liveshow.dao.DarkroomRoomMapper;
import org.liveshow.entity.DarkroomRoom;
import org.liveshow.service.DarkroomRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class DarkroomRoomServiceImpl implements DarkroomRoomService {
    @Autowired
    private DarkroomRoomMapper darkroomRoomMapper;
    
    @Override
    public int insertDarkRecord(int roomId ,String reason ,int hours , String photo,int managerId){
        DarkroomRoom darkroomRoom = new DarkroomRoom();
        darkroomRoom.setRoomId(roomId);
        darkroomRoom.setReason(reason);
        darkroomRoom.setHours(hours);
        int time = Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000));
        darkroomRoom.setTime(time);
        darkroomRoom.setPhoto(photo);
        darkroomRoom.setState(false);
        darkroomRoom.setManagerId(managerId);
        int res = darkroomRoomMapper.insert(darkroomRoom);
        if (res == 0){
            return 0;
        }
        return res;
    }
}
