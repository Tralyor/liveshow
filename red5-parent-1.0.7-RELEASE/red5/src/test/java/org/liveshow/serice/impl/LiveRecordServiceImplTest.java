package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.entity.LiveRecord;
import org.liveshow.service.LiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Cjn on 2017/12/1.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class LiveRecordServiceImplTest {
    
    @Autowired
    private LiveRecordService liveRecordService;
    
    @Test
    public void addRecord(){
        liveRecordService.addRecord(1);
    }
    
    @Test
    public void stopRecord(){
        liveRecordService.finishRecord(1);
    }
}
