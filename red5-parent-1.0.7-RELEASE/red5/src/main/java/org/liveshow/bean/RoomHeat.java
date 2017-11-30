package org.liveshow.bean;

import org.liveshow.entity.Room;

/**
 * Created by Cjn on 2017/11/28.
 */
public class RoomHeat {
    public Room room;
    public int populartyNow;
    public int getPopulartyMax;
    public boolean roomIsOnline;

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

    public boolean getRoomIsOnline() {
        return roomIsOnline;
    }

    public void setRoomIsOnline(boolean roomIsOnline) {
        this.roomIsOnline = roomIsOnline;
    }

    public void addpopulartyNow(){
        this.populartyNow++;
    }
    public void delete(){
        this.populartyNow--;
    }
    
    public void setMaxPopulation(){
        if (this.populartyNow  > getPopulartyMax){
           getPopulartyMax =  populartyNow;
        }
    }
}
