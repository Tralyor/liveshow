package org.liveshow.bean;

import java.util.List;
import org.liveshow.entity.Room;
import org.liveshow.service.RoomService;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * Created by Cjn on 2017/11/28.
 * spring启动后调用方法吧单例的房间信息的bean全都加载进来
 */

public class InitBean implements ApplicationListener<ContextRefreshedEvent>{
    
    @Autowired
    private RoomService roomService;
    
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        if(contextRefreshedEvent.getApplicationContext().getParent() == null){
            RoomPopularity roomPopularity =   RoomPopularity.getInstance();
            List<Room> roomList = roomService.findAllRoom();
            HashMap<Integer,RoomHeat>  hashMap= new HashMap<Integer,RoomHeat>();
            if (roomList != null){
                for (int i = 0 ;  i < roomList.size() ; i++){
                    Room room  = roomList.get(i);
                    RoomHeat roomHeat = new RoomHeat();
                    roomHeat.setRoom(room);
                    roomHeat.setPopulartyNow(0);
                    roomHeat.setGetPopulartyMax(0);
                    hashMap.put(room.getId(),roomHeat);
                }
            }
            roomPopularity.setRoomIdAndPopularity(hashMap);
        }
       
    }
}
