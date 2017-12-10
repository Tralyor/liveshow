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

    /**
     * 查询直播间最高人气
     * @param userName
     * @return
     */
    Integer selectHighestPopulation(String userName);

    /**
     * 查询直播总时长
     * @param userName
     * @return
     */
    Integer selectWholeDuration(String userName);

    /**
     * 查询直播次数
     * @param userName
     * @return
     */
    Integer countTimes(String userName);

    /**
     * 查询指定日期板块的客流量
     * @param partId
     * @param starttime
     * @param endtime
     * @return
     */
    Integer selectPartPopulationByDate(@Param("partId") int partId, @Param("starttime") int starttime, @Param("endtime") int endtime);

    List<LiveRecord> selectByUserId(int id);

    List<LiveRecord> selectByUserIdAndTime(
    		@Param("id") int id,
			@Param("startTime") int startTime,
			@Param("endTime") int endTime);
}