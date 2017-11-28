package org.liveshow.service.impl;

import org.liveshow.dao.UserMapper;
import org.liveshow.entity.User;
import java.util.List;

import org.liveshow.entity.UserExample;
import org.liveshow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hp on 2017/11/20.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    
    @Transactional
    public List<User> users(){
        UserExample userExample = new UserExample();
        return userMapper.selectByExample(userExample);
    }
}
