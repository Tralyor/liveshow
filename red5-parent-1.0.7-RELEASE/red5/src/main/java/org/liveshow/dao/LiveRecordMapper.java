package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.LiveRecord;
import org.liveshow.entity.LiveRecordExample;

import java.util.List;

public interface LiveRecordMapper {
    int countByExample(LiveRecordExample example);

    int deleteByExample(LiveRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LiveRecord record);

    int insertSelective(LiveRecord record);

    List<LiveRecord> selectByExample(LiveRecordExample example);

    LiveRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LiveRecord record, @Param("example") LiveRecordExample example);

    int updateByExample(@Param("record") LiveRecord record, @Param("example") LiveRecordExample example);

    int updateByPrimaryKeySelective(LiveRecord record);

    int updateByPrimaryKey(LiveRecord record);
}