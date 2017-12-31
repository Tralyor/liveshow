package org.liveshow.dto.manager;

/**
 * Created by asus on 2017/12/12.
 */
public class RoomMuteDTO
{
	private int roomMuteId;
	private String nickName;
	private String realName;
	private int roomId;
	private int moduleId;
	private String moduleName;
	private String reason;
	private String photo;
	private String startTime;
	private String endTime;
	private boolean state;
	private String operateName;

	public RoomMuteDTO()
	{
	}

	public RoomMuteDTO(int moduleId, boolean state)
	{
		this.moduleId = moduleId;
		this.state = state;
	}

	public RoomMuteDTO(int moduleId, String startTime, String endTime, boolean state)
	{
		this.moduleId = moduleId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.state = state;
	}

	public RoomMuteDTO(int roomMuteId, String nickName, String realName, int roomId, int moduleId, String moduleName,
			String reason, String photo, String startTime, String endTime, boolean state, String operateName)
	{
		this.roomMuteId = roomMuteId;
		this.nickName = nickName;
		this.realName = realName;
		this.roomId = roomId;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.reason = reason;
		this.photo = photo;
		this.startTime = startTime;
		this.endTime = endTime;
		this.state = state;
		this.operateName = operateName;
	}

	public int getRoomMuteId()
	{
		return roomMuteId;
	}

	public void setRoomMuteId(int roomMuteId)
	{
		this.roomMuteId = roomMuteId;
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

	public String getOperateName()
	{
		return operateName;
	}

	public void setOperateName(String operateName)
	{
		this.operateName = operateName;
	}
}
