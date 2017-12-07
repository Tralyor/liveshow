package org.liveshow.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:spring/spring-*.xml",
})
public class RoomMapperTest
{
	@Autowired
	private RoomMapper roomMapper;

	@Test
	public void selectByUserIdWithModule() throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		Room room = roomMapper.selectByUserIdWithModule(1);
		System.out.println(mapper.writeValueAsString(room));
	}

}
