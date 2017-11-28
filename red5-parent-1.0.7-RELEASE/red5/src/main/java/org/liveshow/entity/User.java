package org.liveshow.entity;

public class User {
    private Integer id;

    private String password;

    private String loginName;

    private String nickName;

    private Integer type;

    public User(Integer id, String password, String loginName, String nickName, Integer type) {
        this.id = id;
        this.password = password;
        this.loginName = loginName;
        this.nickName = nickName;
        this.type = type;
    }

    public User() {
        super();
    }

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
        this.password = password == null ? null : password.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}