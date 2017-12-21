package org.liveshow.entity.CombinationEntity;

/**
 * Created by Zzzz on 2017/12/11.
 */
public class ApplicationInfo {

    private Integer id;

    private Integer userId;

    private String realName;

    private String idcardId;

    private String idcardPhoto;

    private Integer applyTime;

    private String nickName;

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdcardId() {
        return idcardId;
    }

    public void setIdcardId(String idcardId) {
        this.idcardId = idcardId;
    }

    public String getIdcardPhoto() {
        return idcardPhoto;
    }

    public void setIdcardPhoto(String idcardPhoto) {
        this.idcardPhoto = idcardPhoto;
    }

    public Integer getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Integer applyTime) {
        this.applyTime = applyTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
