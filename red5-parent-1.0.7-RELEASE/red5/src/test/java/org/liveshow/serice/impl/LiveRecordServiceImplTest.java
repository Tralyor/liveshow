package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dto.PersonalLiveRecordDTO;
import org.liveshow.dto.Show;
import org.liveshow.entity.LiveRecord;
import org.liveshow.service.LiveRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

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

    @Test
    public void getLiveRecordByUserId()
	{
		System.out.println(System.currentTimeMillis());
		System.out.println(new Date(System.currentTimeMillis()));
		List<PersonalLiveRecordDTO> personalLiveRecordDTOList = liveRecordService.getLiveRecordByUserId(1);
		for (PersonalLiveRecordDTO p : personalLiveRecordDTOList)
		{
			System.out.println(p);
		}
	}

	@Test
	public void getLiveRecordByTime()
	{
		Show show = liveRecordService.getLiveRecordByTime(1, "2017-12-01", "2017-12-01");
		System.out.println(show.getMessage());
	}
}
