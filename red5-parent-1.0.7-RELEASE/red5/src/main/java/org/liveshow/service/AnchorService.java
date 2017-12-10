package org.liveshow.service;

import org.liveshow.dto.Show;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface AnchorService {

    /**
     * 获取主播信息和直播情况信息
     * @param userName
     * @return
     */
    Show getAchorInfo(String userName);

    /**
     * 获取主播的直播时长和人气的图表信息
     * @param userName
     * @param startTime
     * @param endTime
     * @return
     */
    Show getChartInfo(String userName, int startTime, int endTime);

}
