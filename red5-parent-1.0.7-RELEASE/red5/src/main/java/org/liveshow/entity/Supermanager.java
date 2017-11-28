package org.liveshow.entity;

public class Supermanager {
    private Integer id;

    private Integer userId;

    private String name;

    private Integer moduleId;

    private String idcardId;

    private String telephone;

    private String address;

    public Supermanager(Integer id, Integer userId, String name, Integer moduleId, String idcardId, String telephone, String address) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.moduleId = moduleId;
        this.idcardId = idcardId;
        this.telephone = telephone;
        this.address = address;
    }

    public Supermanager() {
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

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}