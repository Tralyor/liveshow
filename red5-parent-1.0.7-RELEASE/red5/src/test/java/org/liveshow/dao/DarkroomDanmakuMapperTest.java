package org.liveshow.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomDanma;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomNumByDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
		System.out.println(mapper.writeValueAsString(darkroomDanmakuMapper.selectExpiredByUserId(1, false)));
	}

	@Test
	public void selectExpiredByUserId() throws Exception
	{
	}

	@Test
	public void selectAllMute() throws Exception
	{
		List<ManagerDarkroomDanma> managerDarkroomDanmaList =
				darkroomDanmakuMapper.selectManagerMuteByModuleIdAndState(0, false);
		for (ManagerDarkroomDanma m : managerDarkroomDanmaList)
		{
			System.out.println(m);
		}
	}

	@Test
	public void countDarkDanmakuNumByDate() throws Exception
	{
		for (int i = 7; i >= 1; i--)
		{
			ManagerDarkroomNumByDate managerDarkroomNumByDate = darkroomDanmakuMapper.countDarkDanmakuNumByDate(-i);
			System.out.println(managerDarkroomNumByDate.getDate() + ", " + managerDarkroomNumByDate.getNum());
		}
	}
}
