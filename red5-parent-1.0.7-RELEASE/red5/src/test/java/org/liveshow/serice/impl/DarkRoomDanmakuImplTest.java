package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.entity.DarkroomDanmaku;
import org.liveshow.service.DarkroomDanmakuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Cjn on 2017/12/2.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DarkRoomDanmakuImplTest {
    
    @Autowired
    private DarkroomDanmakuService  darkroomDanmakuService;
    
    @Test
    public void add(){
        DarkroomDanmaku darkroomDanmaku = new DarkroomDanmaku();
        darkroomDanmaku.setDanmakuId(22);
        darkroomDanmaku.setHours(2000);
        darkroomDanmakuService.addDarkRoomDanmaku(darkroomDanmaku);
    }
}
