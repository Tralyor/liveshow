package org.liveshow.service;

import org.liveshow.dto.Show;

import java.util.Map;

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
}
