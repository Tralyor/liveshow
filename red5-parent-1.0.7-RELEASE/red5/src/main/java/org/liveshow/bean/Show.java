package org.liveshow.bean;

/**
 * Created by Cjn on 2017/11/30.
 */
public class Show {
    public Object data;
    public int state;
    public String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
