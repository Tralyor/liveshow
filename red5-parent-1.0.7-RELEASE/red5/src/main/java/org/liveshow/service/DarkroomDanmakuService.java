package org.liveshow.service;

import org.liveshow.dto.PersonalMuteDTO;
import org.liveshow.dto.Show;
import org.liveshow.entity.DarkroomDanmaku;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface DarkroomDanmakuService {
    
    int addDarkRoomDanmaku(DarkroomDanmaku darkroomDanmaku);
    
    int isDark(int userId,int roomId);

	/**
	 * 获取未过期的禁言名单
	 * @param userId
	 * @return
	 */
	List<PersonalMuteDTO> getNotExpiredMute(int userId);

	/**
	 * 获取已过期的禁言名单
	 * @param userId
	 * @return
	 */
    List<PersonalMuteDTO> getExpireMute(int userId);

    Show cancelMute(int id);
}
