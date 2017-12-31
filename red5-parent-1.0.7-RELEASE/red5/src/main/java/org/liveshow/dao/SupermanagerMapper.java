package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.CombinationEntity.SuperManagerWithPerformance;
import org.liveshow.entity.Supermanager;
import org.liveshow.entity.SupermanagerExample;
import org.liveshow.entity.User;

import java.util.List;

public interface SupermanagerMapper {
    int countByExample(SupermanagerExample example);

    int deleteByExample(SupermanagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Supermanager record);

    int insertSelective(Supermanager record);

    List<Supermanager> selectByExample(SupermanagerExample example);

    Supermanager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Supermanager record, @Param("example") SupermanagerExample example);

    int updateByExample(@Param("record") Supermanager record, @Param("example") SupermanagerExample example);

    int updateByPrimaryKeySelective(Supermanager record);

    int updateByPrimaryKey(Supermanager record);

	/**
	 * 获取所有超管信息
	 * 以及
	 * 封禁直播间数量、误封禁直播间数量
	 * @return
	 */
	List<SuperManagerWithPerformance> selectAllSuperManager();

	/**
	 * 根据模块id获取超管
	 * @param moduleId
	 * @return
	 */
	List<SuperManagerWithPerformance> selectSuperManagerByModuleId(@Param("moduleId") int moduleId);

	/**
	 * 根据用户名获取超管
	 * @param loginName
	 * @return
	 */
	Supermanager selectByLoginName(String loginName);
}
