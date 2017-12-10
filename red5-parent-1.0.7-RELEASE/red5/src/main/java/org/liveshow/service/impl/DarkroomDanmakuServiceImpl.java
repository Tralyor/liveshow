package org.liveshow.service.impl;

import org.liveshow.dao.DarkroomDanmakuMapper;
import org.liveshow.entity.DarkroomDanmaku;
import org.liveshow.service.DarkroomDanmakuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
