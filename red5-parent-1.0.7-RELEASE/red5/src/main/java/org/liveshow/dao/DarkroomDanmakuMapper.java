package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.DarkroomDanmaku;
import org.liveshow.entity.DarkroomDanmakuExample;

import java.util.List;

public interface DarkroomDanmakuMapper {
    int countByExample(DarkroomDanmakuExample example);

    int deleteByExample(DarkroomDanmakuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DarkroomDanmaku record);

    int insertSelective(DarkroomDanmaku record);

    List<DarkroomDanmaku> selectByExample(DarkroomDanmakuExample example);

    DarkroomDanmaku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DarkroomDanmaku record, @Param("example") DarkroomDanmakuExample example);

    int updateByExample(@Param("record") DarkroomDanmaku record, @Param("example") DarkroomDanmakuExample example);

    int updateByPrimaryKeySelective(DarkroomDanmaku record);

    int updateByPrimaryKey(DarkroomDanmaku record);
    
    List<DarkroomDanmaku> isDark(@Param("userId") int userId , int roomId);
}