package org.liveshow.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dto.PersonalLiveSettingDTO;
import org.liveshow.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:spring/spring-*.xml",
})
public class RoomeServiceImplTest
{
	@Autowired
	private RoomService roomService;

	@Test
	public void getPersonalLiveSetting() throws Exception
	{
		PersonalLiveSettingDTO personalLiveSettingDTO = roomService.getPersonalLiveSetting(1);
		System.out.println(personalLiveSettingDTO);
	}

}
