package org.liveshow.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-*.xml" })
public class DarkroomDanmakuMapperTest
{
	@Autowired
	private DarkroomDanmakuMapper darkroomDanmakuMapper;
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void selectNotExpiredByUserId() throws Exception
	{
		System.out.println(mapper.writeValueAsString(darkroomDanmakuMapper.selectNotExpiredByUserId(1)));
	}

	@Test
	public void selectExpiredByUserId() throws Exception
	{
	}

}
