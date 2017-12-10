package org.liveshow.dto;

/**
 * Created by asus on 2017/12/6.
 */
public class PersonalFollowingDTO
{
	private int roomId;
	private String roomName;
	private String livePhoto;
	private String nickName;
	//直播状态
	private boolean liveState;
	//直播时长
	private int liveTime;
	//观众人数
	private int attendance;
	//所属板块
	private int moduleId;
	private String moduleName;

	@Override
	public String toString()
	{
		return "PersonalFollowingDTO{" + "roomId=" + roomId + ", roomName='" + roomName + '\'' + ", livePhoto='"
				+ livePhoto + '\'' + ", nickName='" + nickName + '\'' + ", liveState=" + liveState + ", liveTime="
				+ liveTime + ", attendance=" + attendance + ", moduleId=" + moduleId + ", moduleName='" + moduleName
				+ '\'' + '}';
	}

	public PersonalFollowingDTO()
	{
	}

	public PersonalFollowingDTO(int roomId, String roomName, String livePhoto, String nickName, boolean liveState,
			int moduleId, String moduleName)
	{
		this.roomId = roomId;
		this.roomName = roomName;
		this.livePhoto = livePhoto;
		this.nickName = nickName;
		this.liveState = liveState;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}

	public PersonalFollowingDTO(int roomId, String roomName, String livePhoto, String nickName, boolean liveState,
			int liveTime, int attendance, int moduleId, String moduleName)
	{
		this.roomId = roomId;
		this.roomName = roomName;
		this.livePhoto = livePhoto;
		this.nickName = nickName;
		this.liveState = liveState;
		this.liveTime = liveTime;
		this.attendance = attendance;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}

	public int getRoomId()
	{
		return roomId;
	}

	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
	}

	public String getRoomName()
	{
		return roomName;
	}

	public void setRoomName(String roomName)
	{
		this.roomName = roomName;
	}

	public String getLivePhoto()
	{
		return livePhoto;
	}

	public void setLivePhoto(String livePhoto)
	{
		this.livePhoto = livePhoto;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public boolean isLiveState()
	{
		return liveState;
	}

	public void setLiveState(boolean liveState)
	{
		this.liveState = liveState;
	}

	public int getLiveTime()
	{
		return liveTime;
	}

	public void setLiveTime(int liveTime)
	{
		this.liveTime = liveTime;
	}

	public int getAttendance()
	{
		return attendance;
	}

	public void setAttendance(int attendance)
	{
		this.attendance = attendance;
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
}
