package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomNumByDate;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomNumByModule;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomRoom;
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
	 * 根据ManagerDarkroomRoom中的
	 * moduleId,startTime, duration, state
	 * 查询ManagerDarkroomRoomList
	 * @param managerDarkroomRoom
	 * @return
	 */
	List<ManagerDarkroomRoom> selectDarkRoomByManagerDarkroomRoom(ManagerDarkroomRoom managerDarkroomRoom);

	/**
	 * 获取各个模块被禁的主播
	 * @return
	 */
	List<ManagerDarkroomNumByModule> countDarkRoomNumByModule();

	/**
	 * 根据距今天的天数获取每天的封禁主播数
	 * @param i
	 * @return
	 */
	ManagerDarkroomNumByDate countDarkRoomNumByDate(int i);
}
