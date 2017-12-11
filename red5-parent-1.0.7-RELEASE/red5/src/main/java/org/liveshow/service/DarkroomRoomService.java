package org.liveshow.service;

import org.liveshow.dto.Show;
import org.liveshow.entity.CombinationEntity.DarkRoomInfo;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface DarkroomRoomService {
    
    int insertDarkRecord(int roomId ,String reason ,int hours ,String photo, int managerId);
    
    int isDrakRoom(int roomId);

    /**
     * 获取所有未解封的禁封直播间
     * @return
     */
    List<DarkRoomInfo> initDarkRoomInfos();

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
