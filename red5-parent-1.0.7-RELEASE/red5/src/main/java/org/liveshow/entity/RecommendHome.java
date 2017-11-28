package org.liveshow.entity;

import java.util.Date;

public class RecommendHome {
    private Integer id;

    private Integer roomId;

    private Date time;

    public RecommendHome(Integer id, Integer roomId, Date time) {
        this.id = id;
        this.roomId = roomId;
        this.time = time;
    }

    public RecommendHome() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}