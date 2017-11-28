package org.liveshow.entity;

public class Care {
    private Integer id;

    private Integer userId;

    private Integer roomId;

    private Integer time;

    public Care(Integer id, Integer userId, Integer roomId, Integer time) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.time = time;
    }

    public Care() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}