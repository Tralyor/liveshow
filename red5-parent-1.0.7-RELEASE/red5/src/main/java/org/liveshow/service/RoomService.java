package org.liveshow.service;

import java.util.List;

import org.liveshow.entity.CombinationEntity.RoomAndOnwer;
import org.liveshow.entity.Room;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface RoomService {
    
    List<Room> findAllRoom();
    
    List<RoomAndOnwer> findRecoRoom(int recoModule, int pageNo, int pageSize);
    
    RoomAndOnwer findRoomByIdWidhtOnwer(int roomId);
    
    Room findRoomById(int roomId);
    
    int changeRoomState(int roomId,int state);
    
    void changeMostPop(int roomId);
}
