package org.liveshow.service.impl;

import org.liveshow.bean.RoomHeat;
import org.liveshow.dao.PartMapper;
import org.liveshow.dao.RoomMapper;
import org.liveshow.dao.UserMapper;
import org.liveshow.dao.ApplicationMapper;

import org.liveshow.entity.Part;
import org.liveshow.entity.Room;
import org.liveshow.entity.User;

import org.liveshow.dto.Show;
import org.liveshow.dto.PersonalChangePasswordDTO;
import org.liveshow.dto.PersonalFollowingDTO;
import org.liveshow.dto.PersonalProfileDTO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
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
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private PartMapper partMapper;

    @Autowired
    private ApplicationMapper applicationMapper;

    @Transactional
    public List<User> users() {
        UserExample userExample = new UserExample();
        return userMapper.selectByExample(userExample);
    }

	@Override
	public PersonalProfileDTO getPersonalProfile(int id)
	{
		logger.info("获取id：" + id + "的个人资料");
		Boolean idCardState = applicationMapper.selectPassStateByUserId(id);
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
		logger.info("查找用户关注的直播间");
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

	private PersonalProfileDTO entity2PersonalProfileDTO(User user, Boolean idCardState)
	{
		return new PersonalProfileDTO(user.getNickName(), "", idCardState);
	}

    @Override
	@Transactional
    public Show overviewInfo() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        RoomPopularity roomPopularity = RoomPopularity.getInstance();
        HashMap<Integer, RoomHeat> roomMap = roomPopularity.getRoomIdAndPopularity();
        List<Room> roomList = roomMapper.getAllRoom();
        List<Part> partList = partMapper.selectAll();
        int population = 0;
        int[] partPopulation = new int[partList.size()];
        String[] partName = new String[partList.size()];
        String[] anchorName = new String[7];
        int[] roomPopulation = new int[]{0, 0, 0, 0, 0, 0, 0};
        int position = 0;
        for (int i = 0; i < roomList.size(); i++) {
            population += roomMap.get(roomList.get(i).getId()).getPopulartyNow();
            if (roomMap.get(roomList.get(i).getId()).getPopulartyNow() > roomPopulation[position] && roomMap.get(roomList.get(i).getId()).getRoomIsOnline() == true) {
                anchorName[position] = userMapper.selectByPrimaryKey(roomList.get(i).getUserId()).getNickName();
                roomPopulation[position] = roomMap.get(roomList.get(i).getId()).getPopulartyNow();
            }
            int min = roomPopulation[0];
            for (int n = 0; n < 7; n++) {
                if (roomPopulation[n] < roomPopulation[position]) {
                    position = n;
                }
            }
        }
        hashMap.put("population", population);
        hashMap.put("anchorName", anchorName);
        hashMap.put("roomPopulation", roomPopulation);
        for (int i = 0; i < partList.size(); i++) {
            List<Room> rooms = roomMapper.getRoomByPart(partList.get(i).getId());
            partName[i] = partList.get(i).getName();
            int temp = 0;
            for (int n = 0; n < rooms.size(); n++) {
                temp += roomMap.get(rooms.get(n).getId()).getPopulartyNow();
            }
            partPopulation[i] = temp;
        }
        hashMap.put("partName", partName);
        hashMap.put("partPopulation", partPopulation);
        Show show = new Show();
        show.setData(hashMap);
        show.setState(1);
        show.setMessage("表格数据申请成功");
        return show;
    }

    @Override
    public User doLogin(String loginName, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andLoginNameEqualTo(loginName.trim());
        criteria.andPasswordEqualTo(password);
        List<User> lists = userMapper.selectByExample(userExample);
        if (lists == null || lists.size() != 1) {
            return null;
        }
        return lists.get(0);
    }

	@Override
	@Transactional
	public Show doRegister(String loginName, String password, String nickName) {
    	Show show = new Show();
    	User user = new User();
    	int loginNameState = userMapper.confirmLoginName(loginName);
    	int nickNameState = userMapper.confirmNickName(nickName);
    	if (loginNameState != 0){
    		show.setState(0);
    		show.setMessage("该用户名已被注册");
		}else if(nickNameState != 0){
			show.setState(0);
			show.setMessage("该昵称已被注册");
		}else {
			user.setType(0);
			user.setLoginName(loginName);
			user.setPassword(password);
			user.setNickName(nickName);
			userMapper.insert(user);
			show.setMessage("注册成功");
			show.setState(1);
		}
		return show;
	}

	@Override
	@Transactional
	public User adminLogin(String loginName, String password) {
    	Show show = new Show();
    	int i = userMapper.confirmPasswordAdmin(loginName, password);
    	if(i != 0){
    		return userMapper.selectUserByLoginName(loginName);
		}else {
    		return null;
		}
	}
}
