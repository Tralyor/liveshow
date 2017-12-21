package org.liveshow.service;

import org.liveshow.dto.PersonalMuteDTO;
import org.liveshow.dto.Show;
import org.liveshow.dto.manager.DarkroomByModuleDTO;
import org.liveshow.dto.manager.DarkroomByDateDTO;
import org.liveshow.entity.DarkroomDanmaku;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface DarkroomDanmakuService {
    
    int addDarkRoomDanmaku(DarkroomDanmaku darkroomDanmaku);
    
    int isDark(int userId,int roomId);

	/**
	 * 用户页面
	 * 获取未过期的禁言名单
	 * @param userId
	 * @return
	 */
	List<PersonalMuteDTO> getNotExpiredMute(int userId);

	/**
	 * 用户页面
	 * 获取已过期的禁言名单
	 * @param userId
	 * @return
	 */
    List<PersonalMuteDTO> getExpireMute(int userId);

    Show cancelMute(int id);

	/**
	 * 根据moduleId和state获取封禁名单
	 * @param moduleId
	 * @param state
	 * @return
	 */
	Show searchMute(int moduleId, boolean state);

	/**
	 * 获取图表的数据
	 * 每个板块的封禁游客人数
	 * @return
	 */
	List<DarkroomByModuleDTO> getNumByModule();

	/**
	 * 获取图表的数据
	 * 近7天
	 * @return
	 */
	List<DarkroomByDateDTO> getNumByDate();
}
