package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dao.RecommendModuleMapper;
import org.liveshow.service.RecommendModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Cjn on 2017/11/29.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RecommendModuleServiceImplTest {
    @Autowired
    private RecommendModuleService recommendModuleService;
    @Test
    public void findRecoModule(){
        recommendModuleService.findRecoModul();
    }
}
