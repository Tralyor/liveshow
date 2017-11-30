package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.RecommendHome;
import org.liveshow.entity.RecommendHomeExample;
import org.liveshow.entity.Room;

import java.util.List;

public interface RecommendHomeMapper {
    int countByExample(RecommendHomeExample example);

    int deleteByExample(RecommendHomeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RecommendHome record);

    int insertSelective(RecommendHome record);

    List<RecommendHome> selectByExample(RecommendHomeExample example);

    RecommendHome selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RecommendHome record, @Param("example") RecommendHomeExample example);

    int updateByExample(@Param("record") RecommendHome record, @Param("example") RecommendHomeExample example);

    int updateByPrimaryKeySelective(RecommendHome record);

    int updateByPrimaryKey(RecommendHome record);

    List<Room> findRecoRoom();
}