package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.Care;
import org.liveshow.entity.CareExample;

import java.util.List;

public interface CareMapper {
    int countByExample(CareExample example);

    int deleteByExample(CareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Care record);

    int insertSelective(Care record);

    List<Care> selectByExample(CareExample example);

    Care selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Care record, @Param("example") CareExample example);

    int updateByExample(@Param("record") Care record, @Param("example") CareExample example);

    int updateByPrimaryKeySelective(Care record);

    int updateByPrimaryKey(Care record);
}