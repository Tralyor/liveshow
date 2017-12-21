package org.liveshow.entity;

import java.util.List;

public class Part {
    private Integer id;

    private String name;

    private List<Module> moduleList;

    public Part(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Part() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public List<Module> getModuleList()
	{
		return moduleList;
	}

	public void setModuleList(List<Module> moduleList)
	{
		this.moduleList = moduleList;
	}
}
