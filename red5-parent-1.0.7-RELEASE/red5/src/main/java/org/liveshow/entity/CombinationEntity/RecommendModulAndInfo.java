package org.liveshow.entity.CombinationEntity;

/**
 * Created by Cjn on 2017/11/28.
 */
public class RecommendModulAndInfo {
    private Integer id;

    private Integer partId;

    private String name;

    private String description;

    private String photo;
    
    private boolean type;

    public RecommendModulAndInfo(Integer id, Integer partId, String name, String description, String photo,boolean type) {
        this.id = id;
        this.partId = partId;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.type = type;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public RecommendModulAndInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

}
