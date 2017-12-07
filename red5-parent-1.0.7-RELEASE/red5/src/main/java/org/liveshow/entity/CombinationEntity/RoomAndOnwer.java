package org.liveshow.entity.CombinationEntity;

/**
 * Created by Cjn on 2017/12/4.
 */
public class RoomAndOnwer {
    private Integer id;

    private Integer userId;

    private String name;

    private String streamCode;

    private String notice;

    private String photo;

    private Integer moduleId;

    private Boolean switchJudge;

    private Integer mostPopular;
    

    private String password;

    private String loginName;

    private String nickName;

    private Integer type;
    
    private int RoomIsDark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        this.name = name;
    }

    public String getStreamCode() {
        return streamCode;
    }

    public void setStreamCode(String streamCode) {
        this.streamCode = streamCode;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
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

    public int getRoomIsDark() {
        return RoomIsDark;
    }

    public void setRoomIsDark(int roomIsDark) {
        RoomIsDark = roomIsDark;
    }
}
