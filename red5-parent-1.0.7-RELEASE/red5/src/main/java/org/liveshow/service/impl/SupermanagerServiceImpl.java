package org.liveshow.service.impl;

import org.liveshow.dao.ApplicationMapper;
import org.liveshow.dao.SupermanagerMapper;
import org.liveshow.dao.UserMapper;
import org.liveshow.dto.Show;
import org.liveshow.dto.manager.ModuleDTO;
import org.liveshow.dto.manager.SuperManagerDTO;
import org.liveshow.entity.Application;
import org.liveshow.entity.CombinationEntity.SuperManagerWithPerformance;
import org.liveshow.entity.Supermanager;
import org.liveshow.entity.User;
import org.liveshow.service.SupermanagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class SupermanagerServiceImpl implements SupermanagerService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SupermanagerMapper supermanagerMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ApplicationMapper applicationMapper;

	@Override
	public List<SuperManagerDTO> getAllSuperManager()
	{
		logger.info("数据查出超管的列表并转换成DTO");
		List<SuperManagerWithPerformance> superManagerDTOList = supermanagerMapper.selectAllSuperManager();
		return enetityList2SuperManagerDTOList(superManagerDTOList);
	}

	@Override
	public Show getSuperManagerByModuleId(int moduleId)
	{
		List<SuperManagerWithPerformance> superManagerWithPerformanceList = supermanagerMapper.selectSuperManagerByModuleId(moduleId);
		return new Show(enetityList2SuperManagerDTOList(superManagerWithPerformanceList), 1, "");
	}

	@Override
	@Transactional
	public Show addSuperManager(String loginName, int moduleId)
	{
		User user = userMapper.selectByLoginName(loginName);
		if (user != null)
		{
			logger.info("用户存在");
			Application application = applicationMapper.selectByUserId(user.getId());
			if (application != null)
			{
				logger.info("用户已实名认证");
				Supermanager supermanager = new Supermanager(0, application.getUserId(), application.getRealName(),
						moduleId, application.getIdcardId(), application.getTelephone(), "");
				user.setType(2);
				int re1 = supermanagerMapper.insert(supermanager);
				int re2 = userMapper.updateByPrimaryKey(user);
				if (re1 == 1 && re2 == 1)
				{
					logger.info("添加成功");
					return new Show(null, 1, "添加成功！");
				}
				else
				{
					logger.info("添加失败");
					return new Show(null, 0, "添加失败！稍后再试！");
				}
			}
			else
			{
				logger.info("用户未实名认证");
				return new Show(null, 0, "用户未实名认证！");
			}
		}
		else
		{
			logger.info("用户不存在");
			return new Show(null, 0, "用户不存在！");
		}
	}

	@Override
	@Transactional
	public Show changeSuperManager(String loginName, int moduleId)
	{
		logger.info("获取要修改的superManager");
		Supermanager supermanager = supermanagerMapper.selectByLoginName(loginName);
		logger.info("更改moduleId");
		supermanager.setModuleId(moduleId);

		int re = supermanagerMapper.updateByPrimaryKeySelective(supermanager);
		if (re == 1)
		{
			logger.info("修改成功");
			return new Show(null, 1, "修改成功！");
		}
		else
		{
			logger.info("修改失败");
			return new Show(null, 0, "修改失败！");
		}

	}

	@Override
	@Transactional
	public Show canelSuperManager(String loginName)
	{
		logger.info("获取要取消的superManager");
		Supermanager supermanager = supermanagerMapper.selectByLoginName(loginName);
		logger.info("更改用户的type");
		User user = new User();
		user.setId(supermanager.getUserId());
		user.setType(1);

		int re1 = supermanagerMapper.deleteByPrimaryKey(supermanager.getId());
		int re2 = userMapper.updateByPrimaryKeySelective(user);
		if (re1 == 1 && re2 == 1)
		{
			logger.info("取消成功");
			return new Show(null, 1, "取消成功！");
		}
		else
		{
			logger.info("取消失败");
			return new Show(null, 0, "取消失败！");
		}
	}

	private SuperManagerDTO entity2SuperManagerDTO(SuperManagerWithPerformance superManagerWithPerformance)
	{
		String falseProportion;
		if (superManagerWithPerformance.getRoomNum() != 0)
		{
			falseProportion = String.format("%.2f%%", (double)(superManagerWithPerformance.getFalseRoomNum()) / superManagerWithPerformance.getRoomNum());
		}
		else
		{
			falseProportion = "0.00%";
		}
		return new SuperManagerDTO(superManagerWithPerformance.getManagerId(), superManagerWithPerformance.getLoginName(),
				superManagerWithPerformance.getRealName(), superManagerWithPerformance.getModuleName(),
				superManagerWithPerformance.getIdNum(), superManagerWithPerformance.getTel(),
				superManagerWithPerformance.getAddress(), superManagerWithPerformance.getRoomNum(),
				falseProportion);
	}

	private List<SuperManagerDTO> enetityList2SuperManagerDTOList(List<SuperManagerWithPerformance> superManagerWithPerformanceList)
	{
		List<SuperManagerDTO> superManagerDTOList = new ArrayList<>();
		for (SuperManagerWithPerformance s : superManagerWithPerformanceList)
		{
			superManagerDTOList.add(entity2SuperManagerDTO(s));
		}
		return superManagerDTOList;
	}
}
