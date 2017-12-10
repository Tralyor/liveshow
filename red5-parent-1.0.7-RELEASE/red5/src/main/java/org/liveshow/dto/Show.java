package org.liveshow.dto;

/**
 * Created by Cjn on 2017/11/30.
 */
public class Show {
    private Object data;
    private int state;
    private String message;

    public Show()
	{

	}

	public Show(Object data, int state, String message)
	{
		this.data = data;
		this.state = state;
		this.message = message;
	}

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
