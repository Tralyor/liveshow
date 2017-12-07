package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
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
}