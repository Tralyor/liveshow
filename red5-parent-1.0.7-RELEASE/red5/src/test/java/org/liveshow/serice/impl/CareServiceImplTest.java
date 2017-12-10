package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.service.CareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Cjn on 2017/11/30.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CareServiceImplTest {
    @Autowired
    private CareService careService;
    
    @Test
    public void addCare(){
       int res = careService.addCare(1,4); 
    }
    
    @Test
    public void careNum(){
       int res =  careService.careNum(1);

    }
    
    @Test
    public void isCare(){
        int res = careService.isCare(4,1);
    }
    @Test
    public void delete(){
        int res = careService.deleteCare(4,1);
    }
}
