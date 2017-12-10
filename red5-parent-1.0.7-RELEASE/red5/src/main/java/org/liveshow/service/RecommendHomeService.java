package org.liveshow.service;

import java.util.List;
import org.liveshow.entity.Room;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface RecommendHomeService {
    
    List<Room> findAllRecHome();
    
    int addRecoRoom(int roomI,int managerId);
}
