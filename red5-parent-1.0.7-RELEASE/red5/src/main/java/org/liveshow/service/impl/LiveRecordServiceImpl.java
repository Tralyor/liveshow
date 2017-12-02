package org.liveshow.service.impl;

import org.liveshow.dao.LiveRecordMapper;
import org.liveshow.entity.LiveRecord;
import org.liveshow.entity.LiveRecordExample;
import org.liveshow.service.LiveRecordService;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class LiveRecordServiceImpl  implements LiveRecordService{

    @Autowired
    private LiveRecordMapper liveRecordMapper;
    
    @Override
    public int addRecord(int roomId) {
        LiveRecord liveRecord = new LiveRecord();
        liveRecord.setRoomId(roomId);
        liveRecord.setEndTime(0);
        liveRecord.setDuration(0);
        liveRecord.setStartTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
        int res =liveRecordMapper.insert(liveRecord);
        return res;
    }

    @Override
    public int finishRecord(int roomId) {
        LiveRecordExample liveRecordExample = new LiveRecordExample();
        LiveRecordExample.Criteria criteria = liveRecordExample.createCriteria();
        criteria.andEndTimeEqualTo(0);
        criteria.andDurationEqualTo(0);
        criteria.andRoomIdEqualTo(roomId);
        LiveRecord liveRecord = liveRecordMapper.selectByExample(liveRecordExample).get(0);
        int endTime = Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000));
        liveRecord.setEndTime(endTime);
        liveRecord.setDuration(liveRecord.getEndTime()-liveRecord.getStartTime());
        liveRecord.setPopulation(RoomPopularity.getInstance().getRoomIdAndPopularity().get(roomId).getGetPopulartyMax());
        int res = liveRecordMapper.updateByPrimaryKeySelective(liveRecord);
        return res;
    }
}
