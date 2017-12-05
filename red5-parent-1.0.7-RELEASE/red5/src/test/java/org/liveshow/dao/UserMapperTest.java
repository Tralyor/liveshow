package org.liveshow.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:spring/spring-*.xml",
})
public class UserMapperTest
{
	@Autowired
	private UserMapper userMapper;

	@Test
	public void selectByPrimaryKey() throws Exception
	{
		System.out.println(userMapper.selectByPrimaryKey(1));
	}

	@Test
	public void selectUserByPasswordAndIdOrLoginName() throws Exception
	{
		User user1 = new User();
		user1.setPassword("123");
		user1.setLoginName("123");
		User resultUser1 = userMapper.selectUserByPasswordAndIdOrLoginName(user1);
		System.out.println(resultUser1.getNickName());

		User user2 = new User();
		user2.setPassword("123");
		user2.setId(1);
		User resultUser2 = userMapper.selectUserByPasswordAndIdOrLoginName(user2);
		System.out.println(resultUser2.getNickName());
	}
}
