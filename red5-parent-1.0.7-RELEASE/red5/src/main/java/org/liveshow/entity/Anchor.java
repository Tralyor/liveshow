package org.liveshow.entity;

public class Anchor {
    private Integer id;

    private Integer userId;

    private String name;

    private String idcardId;

    private String idcardPhoto;

    private String telephone;

    public Anchor(Integer id, Integer userId, String name, String idcardId, String idcardPhoto, String telephone) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.idcardId = idcardId;
        this.idcardPhoto = idcardPhoto;
        this.telephone = telephone;
    }

    public Anchor() {
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

    public String getIdcardId() {
        return idcardId;
    }

    public void setIdcardId(String idcardId) {
        this.idcardId = idcardId == null ? null : idcardId.trim();
    }

    public String getIdcardPhoto() {
        return idcardPhoto;
    }

    public void setIdcardPhoto(String idcardPhoto) {
        this.idcardPhoto = idcardPhoto == null ? null : idcardPhoto.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }
}