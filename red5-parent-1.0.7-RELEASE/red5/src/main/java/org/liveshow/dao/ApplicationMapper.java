package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.Application;
import org.liveshow.entity.ApplicationExample;
import org.liveshow.entity.CombinationEntity.ApplicationInfo;
import org.liveshow.entity.CombinationEntity.CardState;

import java.util.List;

public interface ApplicationMapper {
    int countByExample(ApplicationExample example);

    int deleteByExample(ApplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Application record);

    int insertSelective(Application record);

    List<Application> selectByExample(ApplicationExample example);

    Application selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationExample example);

    int updateByExample(@Param("record") Application record, @Param("example") ApplicationExample example);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);

	/**
	 * 根据用户名查询
	 * @param userId
	 * @return
	 */
	List<Application> selectByUserId(int userId);

    /**
     * 查询指定日期的主播申请记录
     * @param startTime
     * @param endTime
     * @return
     */
    List<ApplicationInfo> selectApplication(@Param("startTime") int startTime, @Param("endTime") int endTime);

    /**
     * 更新申请的审核状态
     * @param id
     * @param passState
     * @param managerId
     * @return
     */
    int updateApplicationInfo(@Param("id") int id, @Param("passState") Boolean passState, @Param("managerId") int managerId);

	List<CardState> selectPassStateByUserId(int userId);
}
