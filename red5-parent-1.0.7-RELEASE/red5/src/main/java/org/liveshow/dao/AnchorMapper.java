package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.Anchor;
import org.liveshow.entity.AnchorExample;
import org.liveshow.entity.CombinationEntity.AnchorInfo;

import java.util.List;

public interface AnchorMapper {
    int countByExample(AnchorExample example);

    int deleteByExample(AnchorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Anchor record);

    int insertSelective(Anchor record);

    List<Anchor> selectByExample(AnchorExample example);

    Anchor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Anchor record, @Param("example") AnchorExample example);

    int updateByExample(@Param("record") Anchor record, @Param("example") AnchorExample example);

    int updateByPrimaryKeySelective(Anchor record);

    int updateByPrimaryKey(Anchor record);

    /**
     * 查询主播信息
     * @param userName
     * @return
     */
    AnchorInfo selectAnchorInfo(String userName);

    int selectAnchorByName(String userName);

    /**
     * 查询主播指定日期的直播时长
     * @param userName
     * @param starttime
     * @param endtime
     * @return
     */
    Integer selectDurationByDate(@Param("userName") String userName, @Param("starttime") int starttime, @Param("endtime") int endtime);

    /**
     * 查询主播指定日期的直播最高人气
     * @param userName
     * @param starttime
     * @param endtime
     * @return
     */
    Integer selectPopulationByDate(@Param("userName") String userName, @Param("starttime") int starttime, @Param("endtime") int endtime);

}