package org.liveshow.dto.manager;

import java.util.List;

/**
 * Created by asus on 2017/12/14.
 */
public class MuteByDateDTO
{
	private List<DarkroomByDateDTO> roomList;
	private List<DarkroomByDateDTO> danmaList;

	public MuteByDateDTO(List<DarkroomByDateDTO> roomList, List<DarkroomByDateDTO> danmaList)
	{
		this.roomList = roomList;
		this.danmaList = danmaList;
	}

	public List<DarkroomByDateDTO> getRoomList()
	{
		return roomList;
	}

	public void setRoomList(List<DarkroomByDateDTO> roomList)
	{
		this.roomList = roomList;
	}

	public List<DarkroomByDateDTO> getDanmaList()
	{
		return danmaList;
	}

	public void setDanmaList(List<DarkroomByDateDTO> danmaList)
	{
		this.danmaList = danmaList;
	}
}
