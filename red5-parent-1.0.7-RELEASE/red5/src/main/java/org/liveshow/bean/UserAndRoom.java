package org.liveshow.bean;

import org.liveshow.entity.User;

/**
 * Created by Cjn on 2017/11/27.
 */
public class UserAndRoom {
   public User user;
   public int roomId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
