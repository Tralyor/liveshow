package org.liveshow.bean;

import org.liveshow.entity.Room;

/**
 * Created by Cjn on 2017/11/28.
 */
public class RoomHeat {
    public Room room;
    public int populartyNow;
    public int getPopulartyMax;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getPopulartyNow() {
        return populartyNow;
    }

    public void setPopulartyNow(int populartyNow) {
        this.populartyNow = populartyNow;
    }

    public int getGetPopulartyMax() {
        return getPopulartyMax;
    }

    public void setGetPopulartyMax(int getPopulartyMax) {
        this.getPopulartyMax = getPopulartyMax;
    }
    
    public void setMaxPopulation(){
        if (this.populartyNow  > getPopulartyMax){
           getPopulartyMax =  populartyNow;
        }
    }
}
