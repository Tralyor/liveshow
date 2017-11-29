package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Cjn on 2017/11/29.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomServiceImplTest {
    @Autowired
    private RoomService roomService;
    
    @Test
    public void findRecoRoom(){
        roomService.findRecoRoom(1,0,4);
    }
}
