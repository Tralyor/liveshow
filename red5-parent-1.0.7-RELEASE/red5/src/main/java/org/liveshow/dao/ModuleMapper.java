package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.bouncycastle.math.raw.Mod;
import org.liveshow.entity.Module;
import org.liveshow.entity.ModuleExample;

import java.util.List;

public interface ModuleMapper {
    int countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    /**
     * 获取所有模块信息
     * @return
     */
    List<Module> selectAll();

    /**
     * 删除某一板块的所有模块
     * @param partId
     * @return
     */
    int deleteByPartId(int partId);

    /**
     * 更新模块名字
     * @param id
     * @param name
     * @return
     */
    int updateNameById(@Param("id") int id, @Param("name") String name);

    /**
     * 更新说明
     * @param id
     * @param description
     * @return
     */
    int updateDescriptionById(@Param("id") int id, @Param("description") String description);

    /**
     * 更新图片路径
     * @param id
     * @param photo
     * @return
     */
    int updatePhotoById(@Param("id") int id, @Param("photo") String photo);

    List<Module> findByPart(@Param("typeNum") int typeNum);
}