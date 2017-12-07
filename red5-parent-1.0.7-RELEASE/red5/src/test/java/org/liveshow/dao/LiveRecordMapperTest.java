package org.liveshow.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.entity.LiveRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:spring/spring-*.xml",
})
public class LiveRecordMapperTest
{
	@Autowired
	private LiveRecordMapper liveRecordMapper;

	@Test
	public void selectByUserId() throws Exception
	{
		List<LiveRecord> liveRecordList = liveRecordMapper.selectByUserId(1);
		for (LiveRecord l : liveRecordList)
		{
			System.out.println(l.getId());
		}
	}

	@Test
	public void selectByUserIdAndTime()
	{
		List<LiveRecord> liveRecordList = liveRecordMapper.selectByUserIdAndTime(1, 1512057600, 1512225318);
		for (LiveRecord l : liveRecordList)
		{
			System.out.println(l);
		}
	}
}
