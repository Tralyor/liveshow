package org.liveshow.service;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface DarkroomRoomService {
    
    int insertDarkRecord(int roomId ,String reason ,int hours ,String photo, int managerId);
    
}
