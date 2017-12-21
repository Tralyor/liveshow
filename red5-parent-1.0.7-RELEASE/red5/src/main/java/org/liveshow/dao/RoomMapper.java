package org.liveshow.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.CombinationEntity.RoomAndOwner;
import org.liveshow.entity.Room;
import org.liveshow.entity.RoomExample;

public interface RoomMapper {
    int countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);

    /**
     * 获取所有房间
     * @return
     */
    List<Room> getAllRoom();

    /**
     * 获取所有某板块的房间
     * @return
     */
    List<Room> getRoomByPart(int partId);

    Room selectByUserIdWithModule(int userId);

    List<RoomAndOwner> findRecoRoom(@Param("moduleId") int moduleId , @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    RoomAndOwner findRoomById(int roomId);

    int updateRoomWithoutSwitchJudge(Room room);
}
