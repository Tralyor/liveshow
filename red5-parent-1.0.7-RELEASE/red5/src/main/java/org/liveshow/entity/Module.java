package org.liveshow.entity;

public class Module {
    private Integer id;

    private Integer partId;

    private Part part;

    private String name;

    private String description;

    private String photo;

    public Module(Integer id, Integer partId, String name, String description, String photo) {
        this.id = id;
        this.partId = partId;
        this.name = name;
        this.description = description;
        this.photo = photo;
    }

    public Module() {
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

	public Part getPart()
	{
		return part;
	}

	public void setPart(Part part)
	{
		this.part = part;
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
