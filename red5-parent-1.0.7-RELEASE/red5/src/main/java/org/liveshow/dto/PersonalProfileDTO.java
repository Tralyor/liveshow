package org.liveshow.dto;

/**
 * Created by asus on 2017/12/5.
 */
public class PersonalProfileDTO
{
	private String nickName;
	private String pic;
	private boolean idCardState;

	public PersonalProfileDTO(String nickName, String pic, boolean idCardState)
	{
		this.nickName = nickName;
//		this.pic = pic;
		this.pic = "/static/img/logo.jpg";
		this.idCardState = idCardState;
	}

	@Override
	public String toString()
	{
		return "PersonalProfileDTO{" + "nickName='" + nickName + '\'' + ", pic='" + pic + '\'' + ", idCardState="
				+ idCardState + '}';
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public String getPic()
	{
		return pic;
	}

	public void setPic(String pic)
	{
		this.pic = pic;
	}

	public boolean isIdCardState()
	{
		return idCardState;
	}

	public void setIdCardState(boolean idCardState)
	{
		this.idCardState = idCardState;
	}
}
