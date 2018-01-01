package org.liveshow.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dto.PersonalLiveSettingDTO;
import org.liveshow.entity.Room;
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
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getPersonalLiveSetting() throws Exception
	{
		PersonalLiveSettingDTO personalLiveSettingDTO = roomService.getPersonalLiveSetting(3);
		System.out.println(personalLiveSettingDTO);
	}

	@Test
	public void updateLiveSetting() throws Exception
	{
		Room room = new Room();
		room.setId(1);
//		room.setName("田泽儿");
		room.setNotice("啦啦啦");

//		System.out.println(mapper.writeValueAsString(roomService.updateLiveSetting(room)));
	}
}
