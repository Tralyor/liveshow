package org.liveshow.surveillant;

import org.liveshow.bean.RoomHeat;
import org.liveshow.entity.Room;

import java.util.HashMap;

/**
 * Created by Cjn on 2017/11/28.
 */
public class RoomPopularity {
    

    private HashMap<Integer,RoomHeat> roomIdAndPopularity;
    
    private RoomPopularity(){
        
    }
    
    private static RoomPopularity instance = null;
    
    public static  RoomPopularity getInstance(){
         if (instance == null){
             synchronized(RoomPopularity.class){
                 if(instance == null){
                     instance = new RoomPopularity();
                 }
             }
         }
         return instance;
    }


    public void setRoomIdAndPopularity(HashMap<Integer, RoomHeat> roomIdAndPopularity) {
        this.roomIdAndPopularity = roomIdAndPopularity;
    }


    public HashMap<Integer, RoomHeat> getRoomIdAndPopularity() {
        return roomIdAndPopularity;
    }
}
