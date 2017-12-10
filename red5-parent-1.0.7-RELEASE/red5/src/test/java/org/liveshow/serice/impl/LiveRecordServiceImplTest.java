package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dao.LiveRecordMapper;
import org.liveshow.service.LiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Zzzz on 2017/12/8.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class LiveRecordServiceImplTest {

    @Autowired
    private LiveRecordService liveRecordService;

    @Test
    public void test(){
        liveRecordService.getPartsPopulation(1,2000000000);
    }
}
