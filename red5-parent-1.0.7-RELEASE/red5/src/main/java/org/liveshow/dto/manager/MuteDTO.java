package org.liveshow.dto.manager;

/**
 * Created by asus on 2017/12/11.
 */
public class MuteDTO
{
	private int darkRoomDanmaId;
	private String loginName;
	private String nickName;
	private int roomId;
	private String moduleName;
	private String danmaContent;
	private String startTime;
	private String endTime;
	private boolean state;

	public MuteDTO(int darkRoomDanmaId, String loginName, String nickName, int roomId, String moduleName,
			String danmaContent, String startTime, String endTime, boolean state)
	{
		this.darkRoomDanmaId = darkRoomDanmaId;
		this.loginName = loginName;
		this.nickName = nickName;
		this.roomId = roomId;
		this.moduleName = moduleName;
		this.danmaContent = danmaContent;
		this.startTime = startTime;
		this.endTime = endTime;
		this.state = state;
	}

	public int getDarkRoomDanmaId()
	{
		return darkRoomDanmaId;
	}

	public void setDarkRoomDanmaId(int darkRoomDanmaId)
	{
		this.darkRoomDanmaId = darkRoomDanmaId;
	}

	public String getLoginName()
	{
		return loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public String getModuleName()
	{
		return moduleName;
	}

	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	public String getDanmaContent()
	{
		return danmaContent;
	}

	public void setDanmaContent(String danmaContent)
	{
		this.danmaContent = danmaContent;
	}

	public int getRoomId()
	{
		return roomId;
	}

	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

	public boolean isState()
	{
		return state;
	}

	public void setState(boolean state)
	{
		this.state = state;
	}
}
