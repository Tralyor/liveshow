package org.liveshow.entity;

public class DarkroomDanmaku {
    private Integer id;

    private Integer danmakuId;

    private Integer hours;

    private Integer time;

    private Boolean state;

    public DarkroomDanmaku(Integer id, Integer danmakuId, Integer hours, Integer time, Boolean state) {
        this.id = id;
        this.danmakuId = danmakuId;
        this.hours = hours;
        this.time = time;
        this.state = state;
    }

    public DarkroomDanmaku() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDanmakuId() {
        return danmakuId;
    }

    public void setDanmakuId(Integer danmakuId) {
        this.danmakuId = danmakuId;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}