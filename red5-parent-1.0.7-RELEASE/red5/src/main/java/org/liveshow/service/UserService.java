package org.liveshow.service;

import org.apache.ibatis.annotations.Param;
import org.liveshow.dto.PersonalChangePasswordDTO;
import org.liveshow.dto.PersonalFollowingDTO;
import org.liveshow.dto.PersonalProfileDTO;
import org.liveshow.dto.Show;
import org.liveshow.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hp on 2017/11/20.
 */
public interface UserService {
    List<User> users();

    /**
     * 概览的表格的数据
     * @return
     */
    Show overviewInfo();

	/**
	 * 获取个人资料页面的信息
	 * @param id
	 * @return
	 */
	PersonalProfileDTO getPersonalProfile(int id);

	/**
	 * ajax
	 * 更新用户的昵称
	 * @param id
	 * @param nickName
	 * @return
	 */
	Show updateUserNickName(int id, String nickName);

	/**
	 * ajax
	 * 修改用户密码
	 * @param id
	 * @param personalChangePasswordDTO
	 * @return
	 */
	Show updatePassword(int id, PersonalChangePasswordDTO personalChangePasswordDTO);

	/**
	 * 获取用户关注的直播间
	 * @param id
	 * @return
	 */
	List<PersonalFollowingDTO> getPersonFollowing(int id);
    
    User doLogin(String loginName,String password);

    Show doRegister(String loginName, String password, String nickName);

    Show adminLogin(String loginName, String password);

}
