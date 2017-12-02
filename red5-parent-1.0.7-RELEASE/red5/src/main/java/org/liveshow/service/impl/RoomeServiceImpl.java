package org.liveshow.service.impl;

import org.liveshow.dao.RoomMapper;
import org.liveshow.entity.Room;
import org.liveshow.entity.RoomExample;
import org.liveshow.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
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
    @Transactional
    public List<Room> findRecoRoom(int recoModule,int pageNo,int pageSize) {
        List<Room> lists = roomMapper.findRecoRoom(recoModule,pageNo,pageSize);
        if (lists  == null || lists.size() == 0){
            return null;
        }
        return lists;
    }

    @Override
    @Transactional
    public Room findRoomById(int roomId) {
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andIdEqualTo(roomId);
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        if (rooms == null || rooms.size()!= 1){
            return null;
        }
        return rooms.get(0);
    }

    @Override
    public int changeRoomState(int roomId, int state) {
        Room room = findRoomById(roomId);
        if (state == 0)
            room.setSwitchJudge(false);
        else
            room.setSwitchJudge(true);
        roomMapper.updateByPrimaryKeySelective(room);
        return 0;
    }
}
