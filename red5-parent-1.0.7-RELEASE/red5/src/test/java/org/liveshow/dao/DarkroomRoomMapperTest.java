package org.liveshow.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/spring-*.xml"})
public class DarkroomRoomMapperTest
{
	@Autowired
	private DarkroomRoomMapper darkroomRoomMapper;

	@Test
	public void selectDarkRoomByManagerDarkroomRoom() throws Exception
	{
		ManagerDarkroomRoom managerDarkroomRoom =
				new ManagerDarkroomRoom();
		managerDarkroomRoom.setModuleId(0);
		managerDarkroomRoom.setState(false);
		managerDarkroomRoom.setStartTime(1512049237);
		List<ManagerDarkroomRoom> managerDarkroomRoomList =
				darkroomRoomMapper.selectDarkRoomByManagerDarkroomRoom(managerDarkroomRoom);
		for (ManagerDarkroomRoom m : managerDarkroomRoomList)
		{
			System.out.println(m.getDarkroomRoomId());
		}
	}

}
