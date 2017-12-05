package org.liveshow.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dto.ChangePasswordDTO;
import org.liveshow.dto.Show;
import org.liveshow.service.UserService;
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
		ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO();
		changePasswordDTO.setOldPass("123");
		changePasswordDTO.setNewPass("1234");
		changePasswordDTO.setConfirmPass("1234");

		System.out.println(userService.updatePassword(1, changePasswordDTO).getMessage());
	}
}
