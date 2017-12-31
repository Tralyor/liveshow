package org.liveshow.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class SupermanagerMapperTest
{
	@Autowired
	private SupermanagerMapper supermanagerMapper;

	@Test
	public void selectAllSuperManager() throws Exception
	{
		System.out.println(supermanagerMapper.selectAllSuperManager());
	}
}
