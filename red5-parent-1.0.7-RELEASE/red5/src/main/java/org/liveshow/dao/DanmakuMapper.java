package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.Danmaku;
import org.liveshow.entity.DanmakuExample;

import java.util.List;

public interface DanmakuMapper {
    int countByExample(DanmakuExample example);

    int deleteByExample(DanmakuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Danmaku record);

    int insertSelective(Danmaku record);

    List<Danmaku> selectByExample(DanmakuExample example);

    Danmaku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Danmaku record, @Param("example") DanmakuExample example);

    int updateByExample(@Param("record") Danmaku record, @Param("example") DanmakuExample example);

    int updateByPrimaryKeySelective(Danmaku record);

    int updateByPrimaryKey(Danmaku record);

    /**
     * 查询直播间弹幕总数
     * @param userName
     * @return
     */
    Integer countDanmaku(String userName);

}