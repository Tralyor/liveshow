package org.liveshow.entity;

public class DarkroomRoom {
    private Integer id;

    private Integer roomId;

    private String reason;

    private Integer hours;

    private Integer time;

    private String photo;

    private Boolean state;

    private Integer managerId;

    public DarkroomRoom(Integer id, Integer roomId, String reason, Integer hours, Integer time, String photo, Boolean state, Integer managerId) {
        this.id = id;
        this.roomId = roomId;
        this.reason = reason;
        this.hours = hours;
        this.time = time;
        this.photo = photo;
        this.state = state;
        this.managerId = managerId;
    }

    public DarkroomRoom() {
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}