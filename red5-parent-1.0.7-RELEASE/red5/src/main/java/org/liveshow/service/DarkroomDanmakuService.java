package org.liveshow.service;

import org.liveshow.entity.DarkroomDanmaku;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface DarkroomDanmakuService {
    
    int addDarkRoomDanmaku(DarkroomDanmaku darkroomDanmaku);
    
    int isDark(int userId,int roomId);
}
