package org.liveshow.entity;

public class Room {
    private Integer id;

    private Integer userId;

    private String name;

    private String streamCode;

    private String notice;

    private String photo;

    private Integer moduleId;

    private Module module;

    private Boolean switchJudge;

    private Integer mostPopular;

    public Room(Integer id, Integer userId, String name, String streamCode, String notice, String photo, Integer moduleId, Boolean switchJudge, Integer mostPopular) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.streamCode = streamCode;
        this.notice = notice;
        this.photo = photo;
        this.moduleId = moduleId;
        this.switchJudge = switchJudge;
        this.mostPopular = mostPopular;
    }

    public Room() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStreamCode() {
        return streamCode;
    }

    public void setStreamCode(String streamCode) {
        this.streamCode = streamCode == null ? null : streamCode.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

	public Module getModule()
	{
		return module;
	}

	public void setModule(Module module)
	{
		this.module = module;
	}

	public Boolean getSwitchJudge() {
        return switchJudge;
    }

    public void setSwitchJudge(Boolean switchJudge) {
        this.switchJudge = switchJudge;
    }

    public Integer getMostPopular() {
        return mostPopular;
    }

    public void setMostPopular(Integer mostPopular) {
        this.mostPopular = mostPopular;
    }
}
