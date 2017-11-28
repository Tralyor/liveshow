package org.liveshow.entity;

public class Application {
    private Integer id;

    private Integer userId;

    private String realName;

    private String idcardId;

    private String telephone;

    private String idcardPhoto;

    private Integer applyTime;

    private Boolean passState;

    private Boolean lookState;

    private Integer managerId;

    public Application(Integer id, Integer userId, String realName, String idcardId, String telephone, String idcardPhoto, Integer applyTime, Boolean passState, Boolean lookState, Integer managerId) {
        this.id = id;
        this.userId = userId;
        this.realName = realName;
        this.idcardId = idcardId;
        this.telephone = telephone;
        this.idcardPhoto = idcardPhoto;
        this.applyTime = applyTime;
        this.passState = passState;
        this.lookState = lookState;
        this.managerId = managerId;
    }

    public Application() {
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getIdcardId() {
        return idcardId;
    }

    public void setIdcardId(String idcardId) {
        this.idcardId = idcardId == null ? null : idcardId.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getIdcardPhoto() {
        return idcardPhoto;
    }

    public void setIdcardPhoto(String idcardPhoto) {
        this.idcardPhoto = idcardPhoto == null ? null : idcardPhoto.trim();
    }

    public Integer getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Integer applyTime) {
        this.applyTime = applyTime;
    }

    public Boolean getPassState() {
        return passState;
    }

    public void setPassState(Boolean passState) {
        this.passState = passState;
    }

    public Boolean getLookState() {
        return lookState;
    }

    public void setLookState(Boolean lookState) {
        this.lookState = lookState;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}