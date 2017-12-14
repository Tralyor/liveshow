package org.liveshow.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dto.manager.SuperManagerDTO;
import org.liveshow.service.SupermanagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class SupermanagerServiceImplTest
{
	@Autowired
	private SupermanagerService supermanagerService;

	@Test
	public void getAllSuperManager() throws Exception
	{
		List<SuperManagerDTO> superManagerDTOList = supermanagerService.getAllSuperManager();
		for (SuperManagerDTO s : superManagerDTOList)
		{
			System.out.println(s);
		}
	}

	@Test
	public void addSuperManager() throws Exception
	{
		System.out.println(supermanagerService.addSuperManager("cjn", 1));
	}
}
