package org.liveshow.service;


import org.liveshow.dto.Show;

import java.util.Map;
import org.liveshow.dto.PersonalLiveRecordDTO;
import org.liveshow.dto.Show;
import org.liveshow.entity.LiveRecord;

import java.util.List;


/**
 * Created by Cjn on 2017/11/28.
 */
public interface LiveRecordService {

    /**
     * 获取各个板块指定时间的人气信息
     * @param startTime
     * @param endTime
     * @return
     */
    Show getPartsPopulation(int startTime, int endTime);

    int addRecord(int roomId);
    int finishRecord(int roomId);

	/**
	 * 根据用户id获取直播记录
	 * @param id
	 * @return
	 */
	List<PersonalLiveRecordDTO> getLiveRecordByUserId(int id);

	/**
	 * ajax
	 * 根据用户id和时间范围查询直播记录
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	Show getLiveRecordByTime(int id, String startTime, String endTime);
}
