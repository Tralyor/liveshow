package org.liveshow.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.CombinationEntity.RoomAndOnwer;
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
    
    List<RoomAndOnwer> findRecoRoom(@Param("moduleId") int moduleId , @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
    
    RoomAndOnwer findRoomById(int roomId);
}