package org.liveshow.service.impl;

import org.liveshow.dao.DarkroomRoomMapper;
import org.liveshow.dto.Show;
import org.liveshow.entity.CombinationEntity.DarkRoomInfo;
import org.liveshow.entity.DarkroomRoom;
import org.liveshow.service.DarkroomRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public int isDrakRoom(int roomId) {
        List<DarkroomRoom> lists = darkroomRoomMapper.isDarkRoom(roomId);
       if (lists == null || lists.size() == 0){
           return 1;
       }
        return 0;
    }

    @Override
    @Transactional
    public List<DarkRoomInfo> initDarkRoomInfos() {
        return darkroomRoomMapper.selectDarkRoomInfo(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override
    @Transactional
    public Show getDarkRoomInfoByDate(Integer startTime, Integer endTime) {
        Show show = new Show();
        if(startTime == null){
            startTime = Integer.MIN_VALUE;
        }
        if (endTime == null){
            endTime = Integer.MAX_VALUE;
        }
        List<DarkRoomInfo> darkRoomInfos = darkroomRoomMapper.selectDarkRoomInfo(startTime, endTime);
        show.setData(darkRoomInfos);
        show.setState(1);
        show.setMessage("获取禁封直播间信息成功");
        return show;
    }

    @Override
    public Show getDarkRoomInfoByUserName(String userName) {
        Show show = new Show();
        DarkRoomInfo darkRoomInfo = darkroomRoomMapper.selectDarkRoomInfoByNickName(userName);
        if(darkRoomInfo == null){
            show.setState(0);
            show.setMessage("无此主播被禁封信息");
        }else {
            show.setData(darkRoomInfo);
            show.setState(1);
            show.setMessage("获取禁封直播间信息成功");
        }
        return show;
    }

    @Override
    public Show undoDarkRoom(int id, int managerId) {
        Show show = new Show();
        int i = darkroomRoomMapper.updateDarkRoomState(id, managerId);
        if(i != 0){
            show.setState(1);
            show.setMessage("解封成功");
        }else {
            show.setState(0);
            show.setMessage("解封失败");
        }
        return show;
    }

}
