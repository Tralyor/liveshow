package org.liveshow.dto;

/**
 * Created by asus on 2017/12/8.
 */
public class PersonalLiveSettingDTO
{
	private int roomId;

	private String roomName;

	private String notice;

	private String rtmpAddress;

	private String streamCode;

	private String photo;

	private int partId;

	private String partName;

	private int moduleId;

	private String moduleName;

	private boolean liveState;

	@Override
	public String toString()
	{
		return "PersonalLiveSettingDTO{" + "roomId=" + roomId + ", roomName='" + roomName + '\'' + ", notice='" + notice
				+ '\'' + ", rtmpAddress='" + rtmpAddress + '\'' + ", streamCode='" + streamCode + '\'' + ", photo='"
				+ photo + '\'' + ", partId=" + partId + ", partName='" + partName + '\'' + ", moduleId=" + moduleId
				+ ", moduleName='" + moduleName + '\'' + ", liveState=" + liveState + '}';
	}

	public PersonalLiveSettingDTO()
	{
	}

	public PersonalLiveSettingDTO(int roomId, String roomName, String notice, String rtmpAddress, String streamCode,
			String photo, int partId, String partName, int moduleId, String moduleName, boolean liveState)
	{
		this.roomId = roomId;
		this.roomName = roomName;
		this.notice = notice;
		this.rtmpAddress = rtmpAddress;
		this.streamCode = streamCode;
		this.photo = photo;
		this.partId = partId;
		this.partName = partName;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.liveState = liveState;
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

	public String getNotice()
	{
		return notice;
	}

	public void setNotice(String notice)
	{
		this.notice = notice;
	}

	public String getRtmpAddress()
	{
		return rtmpAddress;
	}

	public void setRtmpAddress(String rtmpAddress)
	{
		this.rtmpAddress = rtmpAddress;
	}

	public String getStreamCode()
	{
		return streamCode;
	}

	public void setStreamCode(String streamCode)
	{
		this.streamCode = streamCode;
	}

	public String getPhoto()
	{
		return photo;
	}

	public void setPhoto(String photo)
	{
		this.photo = photo;
	}

	public int getPartId()
	{
		return partId;
	}

	public void setPartId(int partId)
	{
		this.partId = partId;
	}

	public String getPartName()
	{
		return partName;
	}

	public void setPartName(String partName)
	{
		this.partName = partName;
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

	public boolean isLiveState()
	{
		return liveState;
	}

	public void setLiveState(boolean liveState)
	{
		this.liveState = liveState;
	}
}
