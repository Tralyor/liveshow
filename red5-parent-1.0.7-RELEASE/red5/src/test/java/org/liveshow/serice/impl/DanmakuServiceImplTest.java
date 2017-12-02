package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.service.DanmakuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Cjn on 2017/12/1.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DanmakuServiceImplTest {
    @Autowired
    private DanmakuService danmakuService;
    
    @Test
    public void addDanmaku(){
        danmakuService.addDanmaku(1,1,"hh");
    }
}
