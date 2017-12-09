package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
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
	 * 通过userId取未过期的封禁名单
	 * 并且
	 * 起始时间 + 时长 要小于现 在
	 * 过期状态为false
	 * @param userId
	 * @return
	 */
	List<DarkroomDanmaku> selectNotExpiredByUserId(int userId);

	/**
	 * 通过userId取过期的封禁名单
	 * 并且
	 * 起始时间 + 时长 要大于 现在
	 * 或
	 * 过期状态为true
	 * @param userId
	 * @return
	 */
	List<DarkroomDanmaku> selectExpiredByUserId(int userId);

	int cancelMute(int id);
}
