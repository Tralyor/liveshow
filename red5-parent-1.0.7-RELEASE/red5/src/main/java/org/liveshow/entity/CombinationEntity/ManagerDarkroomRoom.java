package org.liveshow.entity.CombinationEntity;

/**
 * Created by asus on 2017/12/12.
 */
public class ManagerDarkroomRoom
{
	private int darkroomRoomId;
	private String nickName;
	private String realName;
	private int roomId;
	private int moduleId;
	private String moduleName;
	private String reason;
	private String photo;
	private int startTime;
	private int endTime;
	private int duration;
	private boolean state;
	private String operateName;

	public ManagerDarkroomRoom()
	{
	}

	public ManagerDarkroomRoom(int darkroomRoomId, int moduleId, int startTime, int endTime, boolean state)
	{
		this.darkroomRoomId = darkroomRoomId;
		this.moduleId = moduleId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.state = state;
	}

	public int getDarkroomRoomId()
	{
		return darkroomRoomId;
	}

	public void setDarkroomRoomId(int darkroomRoomId)
	{
		this.darkroomRoomId = darkroomRoomId;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public int getRoomId()
	{
		return roomId;
	}

	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
	}

	public int getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(int moduleId)
	{
		this.moduleId = moduleId;
	}

	public String getModuleName()
	{
		return moduleName;
	}

	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public String getPhoto()
	{
		return photo;
	}

	public void setPhoto(String photo)
	{
		this.photo = photo;
	}

	public int getStartTime()
	{
		return startTime;
	}

	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}

	public int getEndTime()
	{
		return endTime;
	}

	public void setEndTime(int endTime)
	{
		this.endTime = endTime;
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

	public String getOperateName()
	{
		return operateName;
	}

	public void setOperateName(String operateName)
	{
		this.operateName = operateName;
	}
}
