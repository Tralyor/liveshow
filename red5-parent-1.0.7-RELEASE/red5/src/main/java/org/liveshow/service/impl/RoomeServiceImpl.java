package org.liveshow.service.impl;

import org.liveshow.dao.RoomMapper;
import org.liveshow.entity.Room;
import org.liveshow.entity.RoomExample;
import org.liveshow.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class RoomeServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    /**
     * @Author cjn
     * @return list 所有的房间信息
     */
    @Override
    public List<Room> findAllRoom() {
        RoomExample roomExample = new RoomExample();
        List<Room> list =  roomMapper.selectByExample(roomExample);
        if (list == null || list.size() == 0){
            return null;
        }else
            return list;
    }

    /**
     * @Author Cjn
      * @param recoModule
     * @return lists
     */
    @Override
    public List<Room> findRecoRoom(int recoModule,int pageNo,int pageSize) {
        List<Room> lists = roomMapper.findRecoRoom(recoModule,pageNo,pageSize);
        if (lists  == null || lists.size() == 0){
            return null;
        }
        return lists;
    }


}
