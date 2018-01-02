package org.liveshow.service.impl;

import org.liveshow.dao.DarkroomDanmakuMapper;
import org.liveshow.dto.PersonalMuteDTO;
import org.liveshow.dto.Show;
import org.liveshow.dto.manager.DarkroomByDateDTO;
import org.liveshow.dto.manager.DarkroomByModuleDTO;
import org.liveshow.dto.manager.MuteDTO;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomDanma;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomNumByDate;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomNumByModule;
import org.liveshow.entity.Danmaku;
import org.liveshow.entity.DarkroomDanmaku;
import org.liveshow.entity.User;
import org.liveshow.service.DarkroomDanmakuService;
import org.liveshow.util.TimeEnum;
import org.liveshow.util.TimeTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */

@Service
public class DarkroomDanmakuServiceImpl implements DarkroomDanmakuService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private DarkroomDanmakuMapper darkroomDanmakuMapper;
    
    @Override
    public int addDarkRoomDanmaku(DarkroomDanmaku darkroomDanmaku) {
    	darkroomDanmaku.setState(false);
        int res =  darkroomDanmakuMapper.insert(darkroomDanmaku);
        return res;
    }

    @Override
    public int isDark(int userId, int roomId) {
        List<DarkroomDanmaku> lists = darkroomDanmakuMapper.isDark(userId,roomId);
        if (lists == null || lists.size() == 0){
            return 0;
        }
        return 1;
    }

	@Override
	public List<PersonalMuteDTO> getNotExpiredMute(int userId)
	{
		List<DarkroomDanmaku> darkroomDanmakuList = darkroomDanmakuMapper.selectExpiredByUserId(userId, false);
		return entityList2PersonalMuteDTOList(darkroomDanmakuList);
	}

	@Override
	public List<PersonalMuteDTO> getExpireMute(int userId)
	{
		List<DarkroomDanmaku> darkroomDanmakuList = darkroomDanmakuMapper.selectExpiredByUserId(userId, true);
		return entityList2PersonalMuteDTOList(darkroomDanmakuList);
	}

	@Override
	public Show cancelMute(int id)
	{
		int result = darkroomDanmakuMapper.cancelMute(id);
		if (result != 0)
		{
			return new Show(null, 1, "撤销成功！");
		}
		else
		{
			return new Show(null, 0, "撤销失败！");
		}
	}

	@Override
	public Show searchMute(int moduleId, boolean state)
	{
		List<ManagerDarkroomDanma> managerDarkroomDanmaList =
				darkroomDanmakuMapper.selectManagerMuteByModuleIdAndState(moduleId, state);
		return new Show(entityList2MuteDTOList(managerDarkroomDanmaList), 1, "获取成功");
	}

	@Override
	public List<DarkroomByModuleDTO> getNumByModule()
	{
		logger.info("获取每个模块被封禁的游客数");
		List<DarkroomByModuleDTO> darkroomByModuleDTOList = new ArrayList<>();
		logger.info("转换entity到DTO");
		List<ManagerDarkroomNumByModule> managerDarkroomNumByModuleList =
				darkroomDanmakuMapper.countDarkDanmakuNumByModule();
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
		logger.info("获取近7天每天被封禁的游客数量");
		List<DarkroomByDateDTO> darkroomByDateDTOList = new ArrayList<>();
		logger.info("转换entity到DTO");
		for (int i = 7; i >= 1; i--)
		{
			ManagerDarkroomNumByDate managerDarkroomNumByDate = darkroomDanmakuMapper.countDarkDanmakuNumByDate(-i);
			DarkroomByDateDTO tmp = new DarkroomByDateDTO();
			BeanUtils.copyProperties(managerDarkroomNumByDate, tmp);
			darkroomByDateDTOList.add(tmp);
		}
		return darkroomByDateDTOList;
	}

	private MuteDTO entity2MuteDTO(ManagerDarkroomDanma managerDarkroomDanma)
	{
		String format = "yyyy-MM-dd HH:mm";
		long endTimeLong = managerDarkroomDanma.getStartTime() + managerDarkroomDanma.getDuration();
		logger.info("startTime: " + managerDarkroomDanma.getStartTime() + "endTime: "+ endTimeLong + "duration: " + managerDarkroomDanma.getDuration());
		return new MuteDTO(managerDarkroomDanma.getDarkRoomDanmaId(), managerDarkroomDanma.getLoginName(),
				managerDarkroomDanma.getNickName(), managerDarkroomDanma.getRoomId(),
				managerDarkroomDanma.getModuleName(), managerDarkroomDanma.getDanmaContent(),
				TimeTool.getDateFormat(managerDarkroomDanma.getStartTime(), format),
				TimeTool.getDateFormat(endTimeLong, format), managerDarkroomDanma.isState());
	}

	private List<MuteDTO> entityList2MuteDTOList(List<ManagerDarkroomDanma> managerDarkroomDanmaList)
	{
		List<MuteDTO> muteDTOList = new ArrayList<>();
		for (ManagerDarkroomDanma d : managerDarkroomDanmaList)
		{
			muteDTOList.add(entity2MuteDTO(d));
		}
		return muteDTOList;
	}

	private PersonalMuteDTO entity2PersonalMuteDTO(DarkroomDanmaku darkroomDanmaku)
	{
		String format = "yyyy-MM-dd HH:mm";
		Danmaku danmaku = darkroomDanmaku.getDanmaku();
		User user = danmaku.getUser();
		return new PersonalMuteDTO(darkroomDanmaku.getId(), user.getNickName(),
				danmaku.getContent(), TimeTool.getDateFormat(darkroomDanmaku.getTime(), format),
				TimeEnum.time2String(darkroomDanmaku.getHours()));
	}

	private List<PersonalMuteDTO> entityList2PersonalMuteDTOList(List<DarkroomDanmaku> darkroomDanmakuList)
	{
		List<PersonalMuteDTO> personalMuteDTOList = new ArrayList<>();
		for (DarkroomDanmaku d : darkroomDanmakuList)
		{
			personalMuteDTOList.add(entity2PersonalMuteDTO(d));
		}
		return personalMuteDTOList;
	}
}
