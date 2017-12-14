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

    /**
     * 检查登录名是否重复
     * @param loginName
     * @return
     */
    int confirmLoginName(String loginName);

    /**
     * 检查昵称是否重复
     * @param nickName
     * @return
     */
    int confirmNickName(String nickName);

    /**
     * 更新用户身份
     * @param id
     * @param type
     * @return
     */
    int updateTypeById(@Param("id") int id, @Param("type") int type);

    /**
     * 判断用户名密码是否正确
     * @param loginName
     * @param password
     * @return
     */
    int confirmPasswordAdmin(@Param("loginName") String loginName, @Param("password") String password);

    /**
     * 根据登录名获取用户信息
     * @param loginName
     * @return
     */
    User selectUserByLoginName(String loginName);

}
