package org.liveshow.dao;

import org.apache.ibatis.annotations.Param;
import org.liveshow.dto.PersonalFollowingDTO;
import org.liveshow.entity.User;
import org.liveshow.entity.UserExample;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByPasswordAndIdOrLoginName(User user);

    List<PersonalFollowingDTO> selectFollowingByUserId(int id);
}
