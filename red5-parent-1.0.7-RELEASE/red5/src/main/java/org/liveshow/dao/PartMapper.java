package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.entity.Part;
import org.liveshow.entity.PartExample;

import java.util.List;

public interface PartMapper {
    int countByExample(PartExample example);

    int deleteByExample(PartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Part record);

    int insertSelective(Part record);

    List<Part> selectByExample(PartExample example);

    Part selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Part record, @Param("example") PartExample example);

    int updateByExample(@Param("record") Part record, @Param("example") PartExample example);

    int updateByPrimaryKeySelective(Part record);

    int updateByPrimaryKey(Part record);

    /**
     * 获取所有板块
     * @return
     */
    List<Part> selectAll();

}