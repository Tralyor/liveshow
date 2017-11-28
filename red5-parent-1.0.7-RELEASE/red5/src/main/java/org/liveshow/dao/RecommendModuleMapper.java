package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.RecommendModule;
import org.liveshow.entity.RecommendModuleExample;

import java.util.List;

public interface RecommendModuleMapper {
    int countByExample(RecommendModuleExample example);

    int deleteByExample(RecommendModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RecommendModule record);

    int insertSelective(RecommendModule record);

    List<RecommendModule> selectByExample(RecommendModuleExample example);

    RecommendModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RecommendModule record, @Param("example") RecommendModuleExample example);

    int updateByExample(@Param("record") RecommendModule record, @Param("example") RecommendModuleExample example);

    int updateByPrimaryKeySelective(RecommendModule record);

    int updateByPrimaryKey(RecommendModule record);
}