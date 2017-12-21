package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomDanma;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomNumByDate;
import org.liveshow.entity.CombinationEntity.ManagerDarkroomNumByModule;
import org.liveshow.entity.DarkroomDanmaku;
import org.liveshow.entity.DarkroomDanmakuExample;

import java.util.List;

public interface DarkroomDanmakuMapper {
    int countByExample(DarkroomDanmakuExample example);

    int deleteByExample(DarkroomDanmakuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DarkroomDanmaku record);

    int insertSelective(DarkroomDanmaku record);

    List<DarkroomDanmaku> selectByExample(DarkroomDanmakuExample example);

    DarkroomDanmaku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DarkroomDanmaku record, @Param("example") DarkroomDanmakuExample example);

    int updateByExample(@Param("record") DarkroomDanmaku record, @Param("example") DarkroomDanmakuExample example);

    int updateByPrimaryKeySelective(DarkroomDanmaku record);

    int updateByPrimaryKey(DarkroomDanmaku record);
    
    List<DarkroomDanmaku> isDark(@Param("userId") int userId ,@Param("roomId") int roomId);

	/**
	 * 通过userId取封禁名单
	 * (userId为0为全部)
	 * 并且
	 * 起始时间 + 时长 要大于 现在
	 * 或
	 * 过期状态为true
	 * @param userId
	 * @return
	 */
	List<DarkroomDanmaku> selectExpiredByUserId(
			@Param("userId") int userId,
			@Param("state") boolean state);

	int cancelMute(int id);

	/**
	 * 根据moduleId及过期情况获取封禁名单
	 * (moduleId为0时，为全部)
	 * @param moduleId
	 * @param state
	 * @return
	 */
	List<ManagerDarkroomDanma> selectManagerMuteByModuleIdAndState(
			@Param("moduleId") int moduleId,
			@Param("state") boolean state);

	/**
	 * 获取各个模块被禁的游客
	 * @return
	 */
	List<ManagerDarkroomNumByModule> countDarkDanmakuNumByModule();

	/**
	 * 根据距今天的天数获取每天的封禁游客数
	 * @param i
	 * @return
	 */
	ManagerDarkroomNumByDate countDarkDanmakuNumByDate(int i);
}
