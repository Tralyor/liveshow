package org.liveshow.service;

import org.liveshow.dto.Show;

import org.liveshow.dto.SuperManagerDarkroomRoomDTO;
import org.liveshow.dto.manager.DarkroomByDateDTO;
import org.liveshow.dto.manager.DarkroomByModuleDTO;
import org.liveshow.dto.manager.RoomMuteDTO;

import org.liveshow.entity.CombinationEntity.DarkRoomInfo;

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

    /**
     * 获取所有未解封的禁封直播间
     * @return
     */
    List<SuperManagerDarkroomRoomDTO> initDarkRoomInfos();

    /**
     * 根据日期获取禁封直播间信息
     * @param startTime
     * @param endTime
     * @return
     */
    Show getDarkRoomInfoByDate(Integer startTime, Integer endTime);

    /**
     * 根据主播用户名查询禁封直播间信息
     * @param userName
     * @return
     */
    Show getDarkRoomInfoByUserName(String userName);

    /**
     * 解封直播间
     * @param id
     * @param managerId
     * @return
     */
    Show undoDarkRoom(int id, int managerId);
}
