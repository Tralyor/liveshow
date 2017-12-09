package org.liveshow.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dto.PersonalMuteDTO;
import org.liveshow.service.DarkroomDanmakuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-*.xml" })
public class DarkroomDanmakuServiceImplTest
{
	@Autowired
	private DarkroomDanmakuService darkroomDanmakuService;
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getNotExpiredMute() throws Exception
	{
		List<PersonalMuteDTO> personalMuteDTOList = darkroomDanmakuService.getNotExpiredMute(1);
		for (PersonalMuteDTO p : personalMuteDTOList)
		{
			System.out.println(mapper.writeValueAsString(p));
		}
	}

	@Test
	public void getExpireMute() throws Exception
	{
		List<PersonalMuteDTO> personalMuteDTOList = darkroomDanmakuService.getExpireMute(1);
		for (PersonalMuteDTO p : personalMuteDTOList)
		{
			System.out.println(mapper.writeValueAsString(p));
		}
	}
}
