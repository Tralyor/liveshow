package org.liveshow.service.impl;

import org.liveshow.dao.LiveRecordMapper;
import org.liveshow.dao.PartMapper;

import org.liveshow.dto.Show;
import org.liveshow.dto.PersonalLiveRecordDTO;

import org.liveshow.entity.Part;
import org.liveshow.entity.LiveRecord;
import org.liveshow.entity.LiveRecordExample;

import org.liveshow.service.LiveRecordService;
import org.liveshow.surveillant.RoomPopularity;
import org.liveshow.util.TimeTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class LiveRecordServiceImpl  implements LiveRecordService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PartMapper partMapper;

    @Autowired
    private LiveRecordMapper liveRecordMapper;

    @Override
	@Transactional
    public Show getPartsPopulation(int startTime, int endTime) {
        Show show = new Show();
        int countDay = (endTime - startTime) / 86400;
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Part> partList = partMapper.selectAll();
        map.put("part", partList);
        for(int i = 0;i < partList.size();i++){
            int[] temp = new int[countDay];
            int m = startTime;
            for(int n = 0;n < countDay;n++){
                if (liveRecordMapper.selectPartPopulationByDate(partList.get(i).getId(), m, m + 86400) == null){
                    temp[n] = 0;
                }else{
                    temp[n] = liveRecordMapper.selectPartPopulationByDate(partList.get(i).getId(), m, m + 86400);
                }
                m += startTime;
            }
            map.put(partList.get(i).getName(), temp);
        }
        show.setData(map);
        show.setState(1);
        return show;
    }
    
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

	@Override
	public List<PersonalLiveRecordDTO> getLiveRecordByUserId(int id)
	{
		logger.info("获取用户" + id + "直播记录");
		List<LiveRecord> liveRecordList = liveRecordMapper.selectByUserId(id);
		return entityList2PersonalLiveRecordDTOList(liveRecordList);
	}

	@Override
	public Show getLiveRecordByTime(int id, String startTime, String endTime)
	{
		logger.info("获取用户" + id + "从" + startTime + "到" + endTime + "的直播记录");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = null;
		Date end = null;
		int startTimeStamp = 0;
		int endTimeStamp = 0;
		try
		{
			logger.info("日期由String -> Date");
			if (startTime != null && startTime.length() != 0)
			{
				logger.info("转换startTime");
				start = sdf.parse(startTime);
				startTimeStamp = (int)(start.getTime() / 1000);
			}

			if (endTime != null && endTime.length() != 0)
			{
				logger.info("转换endTime");
				end = sdf.parse(endTime);
				//取这个日期的23:59
				endTimeStamp = (int)(end.getTime() / 1000 + 86400 - 1);
			}

			logger.info("转换成功");
			logger.info("startTimeStamp:" + startTimeStamp);
			logger.info("endTimeStamp:" + endTimeStamp);
		}
		catch (ParseException e)
		{
//			e.printStackTrace();
			logger.info("日期格式错误");
			return new Show(null, 0, "查询失败，日期格式错误！");
		}

		List<LiveRecord> liveRecordList = liveRecordMapper.selectByUserIdAndTime(id, startTimeStamp, endTimeStamp);
		List<PersonalLiveRecordDTO> personalLiveRecordDTOList = entityList2PersonalLiveRecordDTOList(liveRecordList);

		return new Show(personalLiveRecordDTOList, 1, "查询成功！");
	}

	private PersonalLiveRecordDTO entity2PersonalLiveRecordDTO(LiveRecord liveRecord)
	{
		String format = "yyyy-MM-dd HH:mm";
		return new PersonalLiveRecordDTO(TimeTool.getDateFormat(liveRecord.getStartTime(), format),
				TimeTool.getDateFormat(liveRecord.getEndTime(), format), (liveRecord.getDuration() + 60) / 60);
	}

	private List<PersonalLiveRecordDTO> entityList2PersonalLiveRecordDTOList(List<LiveRecord> liveRecordList)
	{
		List<PersonalLiveRecordDTO> personalLiveRecordDTOList = new ArrayList<>();
		for (LiveRecord l : liveRecordList)
		{
			personalLiveRecordDTOList.add(entity2PersonalLiveRecordDTO(l));
		}

		return personalLiveRecordDTOList;
	}
}
