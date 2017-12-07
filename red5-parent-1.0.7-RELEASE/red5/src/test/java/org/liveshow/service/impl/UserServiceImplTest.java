package org.liveshow.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dto.PersonalChangePasswordDTO;
import org.liveshow.dto.Show;
import org.liveshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by asus on 2017/12/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:spring/spring-*.xml",
})
public class UserServiceImplTest
{
	@Autowired
	private UserService userService;

	@Test
	public void getPersonalProfile() throws Exception
	{
		System.out.println(userService.getPersonalProfile(1));
	}

	@Test
	public void updateUserNickName() throws Exception
	{
		Show show = userService.updateUserNickName(3, "孙");
		System.out.println(show.getMessage());
	}

	@Test
	public void updatePassword() throws Exception
	{
		PersonalChangePasswordDTO personalChangePasswordDTO = new PersonalChangePasswordDTO();
		personalChangePasswordDTO.setOldPass("123");
		personalChangePasswordDTO.setNewPass("1234");
		personalChangePasswordDTO.setConfirmPass("1234");

		System.out.println(userService.updatePassword(1, personalChangePasswordDTO).getMessage());
	}

	@Test
	public void getPersonFollowing() throws Exception
	{

	}
}
