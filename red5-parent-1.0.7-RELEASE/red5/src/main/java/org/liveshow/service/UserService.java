package org.liveshow.service;

import org.liveshow.entity.User;
import java.util.List;

/**
 * Created by hp on 2017/11/20.
 */
public interface UserService {
    List<User> users();
    
    User doLogin(String loginName,String password);
}
