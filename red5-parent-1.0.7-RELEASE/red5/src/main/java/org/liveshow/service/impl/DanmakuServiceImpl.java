package org.liveshow.service.impl;

import org.liveshow.dao.DanmakuMapper;
import org.liveshow.dao.DarkroomRoomMapper;
import org.liveshow.entity.Danmaku;
import org.liveshow.service.DanmakuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class DanmakuServiceImpl implements DanmakuService {
    
    @Autowired
    private DanmakuMapper danmakuMapper;
    
    @Override
    public int addDanmaku(int userId, int roomId, String content) {
        Danmaku danmaku = new Danmaku();
        danmaku.setUserId(userId);
        danmaku.setRoomId(roomId);
        danmaku.setContent(content);
        danmaku.setTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
        danmakuMapper.addDanmaku(danmaku);
        return danmaku.getId();
    }
}
