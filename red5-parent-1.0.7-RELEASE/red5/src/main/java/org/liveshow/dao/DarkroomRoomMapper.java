package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.CombinationEntity.DarkRoomInfo;
import org.liveshow.entity.DarkroomRoom;
import org.liveshow.entity.DarkroomRoomExample;

import java.util.List;

public interface DarkroomRoomMapper {
    int countByExample(DarkroomRoomExample example);

    int deleteByExample(DarkroomRoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DarkroomRoom record);

    int insertSelective(DarkroomRoom record);

    List<DarkroomRoom> selectByExample(DarkroomRoomExample example);

    DarkroomRoom selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DarkroomRoom record, @Param("example") DarkroomRoomExample example);

    int updateByExample(@Param("record") DarkroomRoom record, @Param("example") DarkroomRoomExample example);

    int updateByPrimaryKeySelective(DarkroomRoom record);

    int updateByPrimaryKey(DarkroomRoom record);
    
    List<DarkroomRoom> isDarkRoom(int roomId);

    /**
     * 根据时间查询
     * @param startTime
     * @param endTime
     * @return
     */
    List<DarkRoomInfo> selectDarkRoomInfo(@Param("startTime") int startTime, @Param("endTime") int endTime);

    /**
     * 根据主播名称来获取禁封直播间信息
     * @param nickName
     * @return
     */
    DarkRoomInfo selectDarkRoomInfoByNickName(String nickName);

    /**
     * 解封直播间，更新禁封直播间状态
     * @param id
     * @param managerId
     * @return
     */
    int updateDarkRoomState(@Param("id") int id, @Param("managerId") int managerId);

}