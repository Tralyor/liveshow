package org.liveshow.service.impl;

import org.liveshow.dao.DarkroomRoomMapper;
import org.liveshow.dto.Show;
import org.liveshow.dto.SuperManagerDarkroomRoomDTO;
import org.liveshow.dto.manager.DarkroomByDateDTO;
import org.liveshow.dto.manager.DarkroomByModuleDTO;
import org.liveshow.dto.manager.RoomMuteDTO;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomNumByDate;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomNumByModule;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomRoom;
import org.liveshow.entity.CombinationEntity.DarkRoomInfo;

import org.liveshow.entity.DarkroomRoom;
import org.liveshow.service.DarkroomRoomService;
import org.liveshow.util.TimeEnum;
import org.liveshow.util.TimeTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class DarkroomRoomServiceImpl implements DarkroomRoomService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private DarkroomRoomMapper darkroomRoomMapper;
    
    @Override
    public int insertDarkRecord(int roomId ,String reason ,int hours , String photo,int managerId){
        DarkroomRoom darkroomRoom = new DarkroomRoom();
        darkroomRoom.setRoomId(roomId);
        darkroomRoom.setReason(reason);
        darkroomRoom.setHours(hours);
        int time = Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000));
        darkroomRoom.setTime(time);
        darkroomRoom.setPhoto(photo);
        darkroomRoom.setState(false);
        darkroomRoom.setManagerId(managerId);
        int res = darkroomRoomMapper.insert(darkroomRoom);
        if (res == 0){
            return 0;
        }
        return res;
    }

    @Override
    public int isDrakRoom(int roomId) {
        List<DarkroomRoom> lists = darkroomRoomMapper.isDarkRoom(roomId);
       if (lists == null || lists.size() == 0){
           return 1;
       }
        return 0;
    }

	@Override
	public Show getRoomMuteDTO(RoomMuteDTO roomMuteDTO)
	{
		List<ManagerDarkroomRoom> mList = darkroomRoomMapper.selectDarkRoomByManagerDarkroomRoom(
				roomMuteDTO2ManagerDarkroomRoom(roomMuteDTO));
		return new Show(managerDarkroomRoomList2RoomMuteDTOList(mList), 1, "获取成功！");
	}

	@Override
	public List<DarkroomByModuleDTO> getNumByModule()
	{
		logger.info("获取每个模块被封禁的主播数");
		List<DarkroomByModuleDTO> darkroomByModuleDTOList = new ArrayList<>();
		logger.info("转换entity到DTO");
		List<ManagerDarkroomNumByModule> managerDarkroomNumByModuleList = darkroomRoomMapper.countDarkRoomNumByModule();
		for (ManagerDarkroomNumByModule m : managerDarkroomNumByModuleList)
		{
			DarkroomByModuleDTO tmp = new DarkroomByModuleDTO();
			BeanUtils.copyProperties(m, tmp);
			darkroomByModuleDTOList.add(tmp);
		}
		return darkroomByModuleDTOList;
	}

	@Override
	public List<DarkroomByDateDTO> getNumByDate()
	{
		logger.info("获取近7天每天被封禁的主播数量");
		List<DarkroomByDateDTO> darkroomByDateDTOList =
				new ArrayList<>();
		logger.info("转换entity到DTO");
		for (int i = 7; i >= 1; i--)
		{
			ManagerDarkroomNumByDate managerDarkroomNumByDate =
					darkroomRoomMapper.countDarkRoomNumByDate(-i);
			DarkroomByDateDTO tmp = new DarkroomByDateDTO();
			BeanUtils.copyProperties(managerDarkroomNumByDate, tmp);
			darkroomByDateDTOList.add(tmp);
		}
		return darkroomByDateDTOList;
	}

	private ManagerDarkroomRoom roomMuteDTO2ManagerDarkroomRoom(RoomMuteDTO muteDTO)
	{
		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String startTime = muteDTO.getStartTime();
		String endTime = muteDTO.getEndTime();
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

			return new ManagerDarkroomRoom(muteDTO.getRoomMuteId(),
					muteDTO.getModuleId(), startTimeStamp,
					endTimeStamp, muteDTO.isState());
		}
		catch (ParseException e)
		{
			logger.info("日期格式错误");
			return null;
		}
	}

	private RoomMuteDTO managerDarkroomRoom2RoomMuteDTO(ManagerDarkroomRoom m)
	{
		String format = "yyyy-MM-dd hh:mm";
		long endTimeLong = m.getStartTime() + m.getDuration();
		return new RoomMuteDTO(m.getDarkroomRoomId(), m.getNickName(),
				m.getRealName(), m.getRoomId(), m.getModuleId(),
				m.getModuleName(), m.getReason(),
				m.getPhoto(), TimeTool.getDateFormat(m.getStartTime(), format),
				TimeTool.getDateFormat(endTimeLong, format), m.isState(),
				m.getOperateName());
	}

	private List<RoomMuteDTO> managerDarkroomRoomList2RoomMuteDTOList(List<ManagerDarkroomRoom> mList)
	{
		List<RoomMuteDTO> roomMuteDTOList = new ArrayList<>();
		for (ManagerDarkroomRoom m : mList)
		{
			roomMuteDTOList.add(managerDarkroomRoom2RoomMuteDTO(m));
		}
		return roomMuteDTOList;
	}

    @Override
    @Transactional
    public List<SuperManagerDarkroomRoomDTO> initDarkRoomInfos() {
    	String format = "yyyy-MM-dd HH:mm";
    	List<DarkRoomInfo> darkRoomInfoList = darkroomRoomMapper.selectDarkRoomInfo(Integer.MIN_VALUE, Integer.MAX_VALUE);
    	List<SuperManagerDarkroomRoomDTO> darkroomRoomDTOList = new ArrayList<>();
		for (DarkRoomInfo info : darkRoomInfoList)
		{
			SuperManagerDarkroomRoomDTO tmp = new SuperManagerDarkroomRoomDTO();
			BeanUtils.copyProperties(info, tmp);
			tmp.setTime(TimeTool.getDateFormat(info.getTime(), format));
			tmp.setHours(TimeEnum.time2String(info.getHours()));

			darkroomRoomDTOList.add(tmp);
		}
        return darkroomRoomDTOList;
    }

    @Override
    @Transactional
    public Show getDarkRoomInfoByDate(Integer startTime, Integer endTime) {
        Show show = new Show();
        if(startTime == null){
            startTime = Integer.MIN_VALUE;
        }
        if (endTime == null){
            endTime = Integer.MAX_VALUE;
        }
        List<DarkRoomInfo> darkRoomInfos = darkroomRoomMapper.selectDarkRoomInfo(startTime, endTime);
        show.setData(darkRoomInfos);
        show.setState(1);
        show.setMessage("获取禁封直播间信息成功");
        return show;
    }

    @Override
    public Show getDarkRoomInfoByUserName(String userName) {
        Show show = new Show();
        DarkRoomInfo darkRoomInfo = darkroomRoomMapper.selectDarkRoomInfoByNickName(userName);
        if(darkRoomInfo == null){
            show.setState(0);
            show.setMessage("无此主播被禁封信息");
        }else {
            show.setData(darkRoomInfo);
            show.setState(1);
            show.setMessage("获取禁封直播间信息成功");
        }
        return show;
    }

    @Override
    public Show undoDarkRoom(int id, int managerId) {
        Show show = new Show();
        int i = darkroomRoomMapper.updateDarkRoomState(id, managerId);
        if(i != 0){
            show.setState(1);
            show.setMessage("解封成功");
        }else {
            show.setState(0);
            show.setMessage("解封失败");
        }
        return show;
    }
}
