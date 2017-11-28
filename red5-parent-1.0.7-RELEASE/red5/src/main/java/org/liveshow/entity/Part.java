package org.liveshow.entity;

public class Part {
    private Integer id;

    private String name;

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
}