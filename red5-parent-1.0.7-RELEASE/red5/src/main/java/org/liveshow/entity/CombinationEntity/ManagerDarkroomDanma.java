package org.liveshow.entity.CombinationEntity;

/**
 * Created by asus on 2017/12/11.
 */
public class ManagerDarkroomDanma
{
	private int darkRoomDanmaId;
	private String loginName;
	private String nickName;
	private int roomId;
	private String moduleName;
	private String danmaContent;
	private int startTime;
	private int duration;
	private boolean state;

	@Override
	public String toString()
	{
		return "ManagerDarkroomDanma{" + "darkRoomDanmaId=" + darkRoomDanmaId + ", loginName='" + loginName + '\''
				+ ", nickName='" + nickName + '\'' + ", roomId=" + roomId + ", moduleName='" + moduleName + '\''
				+ ", danmaContent='" + danmaContent + '\'' + ", startTime=" + startTime + ", duration=" + duration
				+ ", state=" + state + '}';
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

	public int getRoomId()
	{
		return roomId;
	}

	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
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

	public int getStartTime()
	{
		return startTime;
	}

	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
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
