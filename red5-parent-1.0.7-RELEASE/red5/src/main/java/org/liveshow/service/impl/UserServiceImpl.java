package org.liveshow.service.impl;

import org.liveshow.dao.ApplicationMapper;
import org.liveshow.dao.UserMapper;
import org.liveshow.dto.PersonalChangePasswordDTO;
import org.liveshow.dto.PersonalFollowingDTO;
import org.liveshow.dto.PersonalProfileDTO;
import org.liveshow.dto.Show;
import org.liveshow.entity.User;
import java.util.List;

import org.liveshow.entity.UserExample;
import org.liveshow.service.UserService;
import org.liveshow.surveillant.RoomPopularity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hp on 2017/11/20.
 */
@Service
public class UserServiceImpl implements UserService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;
	@Autowired
    private ApplicationMapper applicationMapper;
    
    @Transactional
    public List<User> users(){
        UserExample userExample = new UserExample();
        return userMapper.selectByExample(userExample);
    }

	@Override
	public PersonalProfileDTO getPersonalProfile(int id)
	{
		logger.info("获取id：" + id + "的个人资料");
		boolean idCardState = false;
		if (applicationMapper.countPassStateByUserId(id) == 1)
		{
			idCardState = true;
		}
		logger.info("id：" + id + "实名状态" + idCardState);
		return entity2PersonalProfileDTO(userMapper.selectByPrimaryKey(id), idCardState);
	}

	@Override
	public Show updateUserNickName(int id, String nickName)
	{
		logger.info("更新id：" + id + "用户的昵称为 " + nickName);
		User user = new User();
		user.setId(id);
		user.setNickName(nickName);

		int result = userMapper.updateByPrimaryKeySelective(user);
		if (result == 1)
		{
			logger.info("昵称修改成功");
			return new Show(null, 1, "昵称修改成功！");
		}
		else
		{
			logger.info("昵称修改失败");
			return new Show(null, 0, "昵称修改失败！");
		}
	}

	@Override
	public Show updatePassword(int id, PersonalChangePasswordDTO personalChangePasswordDTO)
	{
		String oldPass = personalChangePasswordDTO.getOldPass();
		String newPass = personalChangePasswordDTO.getNewPass();
		String confirmPass = personalChangePasswordDTO.getConfirmPass();

		logger.info("修改密码");
		if (!confirmPass.equals(newPass))
		{
			logger.info("新密码：" + newPass +
					" 和确认密码：" + confirmPass + " 不相同");
			return new Show(null, 1, "新密码要和确认密码相同！");
		}
		else
		{
			logger.info("新密码和确认密码相同");
			User user = new User();
			user.setId(id);
			user.setPassword(oldPass);
			if (userMapper.selectUserByPasswordAndIdOrLoginName(user) != null)
			{
				logger.info("原密码正确");
				user.setPassword(newPass);
				int result = userMapper.updateByPrimaryKeySelective(user);
				if (result == 1)
				{
					logger.info("密码修改成功");
					return new Show(null, 1, "密码修改成功！");
				}
				else
				{
					logger.info("密码修改失败");
					return new Show(null, 0, "密码修改失败！");
				}
			}
			else
			{
				logger.info("原密码错误");
				return new Show(null, 0, "原密码错误！");
			}
		}
	}

	@Override
	public List<PersonalFollowingDTO> getPersonFollowing(int id)
	{
		logger.info("获取用户关注的直播间");
		List<PersonalFollowingDTO> personalFollowingDTOList = userMapper.selectFollowingByUserId(id);
		for (PersonalFollowingDTO p : personalFollowingDTOList)
		{
			if (p.isLiveState())
			{
				p.setAttendance(RoomPopularity.getInstance().getRoomIdAndPopularity().get(p.getRoomId()).getPopulartyNow());
			}
		}
		return personalFollowingDTOList;
	}

	private PersonalProfileDTO entity2PersonalProfileDTO(User user, boolean idCardState)
	{
		return new PersonalProfileDTO(user.getNickName(), "", idCardState);
	}

    @Override
    public User doLogin(String loginName,String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginNameEqualTo(loginName.trim());
        criteria.andPasswordEqualTo(password);
        List<User> lists = userMapper.selectByExample(userExample);
        if (lists == null || lists.size() != 1 ){
            return null;
        }
        return lists.get(0);
    }
}
