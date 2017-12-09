package org.liveshow.service.impl;

import org.liveshow.dao.DarkroomDanmakuMapper;
import org.liveshow.dto.PersonalMuteDTO;
import org.liveshow.dto.Show;
import org.liveshow.entity.Danmaku;
import org.liveshow.entity.DarkroomDanmaku;
import org.liveshow.entity.User;
import org.liveshow.service.DarkroomDanmakuService;
import org.liveshow.util.TimeEnum;
import org.liveshow.util.TimeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */

@Service
public class DarkroomDanmakuServiceImpl implements DarkroomDanmakuService {
    
    @Autowired
    private DarkroomDanmakuMapper darkroomDanmakuMapper;
    
    @Override
    public int addDarkRoomDanmaku(DarkroomDanmaku darkroomDanmaku) {
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
		List<DarkroomDanmaku> darkroomDanmakuList = darkroomDanmakuMapper.selectNotExpiredByUserId(userId);
		return entityList2PersonalMuteDTOList(darkroomDanmakuList);
	}

	@Override
	public List<PersonalMuteDTO> getExpireMute(int userId)
	{
		List<DarkroomDanmaku> darkroomDanmakuList = darkroomDanmakuMapper.selectExpiredByUserId(userId);
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
