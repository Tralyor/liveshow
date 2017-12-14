package org.liveshow.service;

import org.liveshow.dto.Show;
import org.liveshow.dto.manager.DarkroomByDateDTO;
import org.liveshow.dto.manager.DarkroomByModuleDTO;
import org.liveshow.dto.manager.RoomMuteDTO;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface DarkroomRoomService {
    
    int insertDarkRecord(int roomId ,String reason ,int hours ,String photo, int managerId);
    
    int isDrakRoom(int roomId);

	/**
	 * 根据RoomMuteDTO查询封禁名单
	 * @return
	 */
	Show getRoomMuteDTO(RoomMuteDTO roomMuteDTO);

	/**
	 * 获取图表的数据
	 * 每个板块的封禁主播人数
	 * @return
	 */
	List<DarkroomByModuleDTO> getNumByModule();

	/**
	 * 获取图表的数据
	 * 近7天
	 * @return
	 */
	List<DarkroomByDateDTO> getNumByDate();
}
