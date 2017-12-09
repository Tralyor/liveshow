package org.liveshow.entity;

public class Danmaku {
    private Integer id;

    private Integer userId;

    private User user;

    private Integer roomId;

    private String content;

    private Integer time;

    public Danmaku(Integer id, Integer userId, Integer roomId, String content, Integer time) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.content = content;
        this.time = time;
    }

    public Danmaku() {
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

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
