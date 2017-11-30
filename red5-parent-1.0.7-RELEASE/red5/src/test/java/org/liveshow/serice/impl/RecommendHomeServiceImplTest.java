package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.service.RecommendHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Cjn on 2017/11/29.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RecommendHomeServiceImplTest {
    @Autowired
    private RecommendHomeService recommendHomeService;
   
    @Test
    public void findAllRecHome(){
        recommendHomeService.findAllRecHome();
    }
}
