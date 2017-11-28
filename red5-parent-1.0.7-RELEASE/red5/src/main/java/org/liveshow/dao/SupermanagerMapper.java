package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.Supermanager;
import org.liveshow.entity.SupermanagerExample;

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
}