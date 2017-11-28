package org.liveshow.entity;

public class RecommendModule {
    private Integer id;

    private Integer moduleId;

    private Boolean type;

    private Integer recoTime;

    public RecommendModule(Integer id, Integer moduleId, Boolean type, Integer recoTime) {
        this.id = id;
        this.moduleId = moduleId;
        this.type = type;
        this.recoTime = recoTime;
    }

    public RecommendModule() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getRecoTime() {
        return recoTime;
    }

    public void setRecoTime(Integer recoTime) {
        this.recoTime = recoTime;
    }
}