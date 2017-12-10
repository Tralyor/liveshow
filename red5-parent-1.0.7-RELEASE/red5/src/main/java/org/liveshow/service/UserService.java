package org.liveshow.service;

import org.liveshow.dto.Show;
import org.liveshow.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hp on 2017/11/20.
 */
public interface UserService {
    List<User> users();

    /**
     * 概览的表格的数据
     * @return
     */
    Show overviewInfo();

}
