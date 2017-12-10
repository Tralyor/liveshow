package org.liveshow.service;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface CareService {
    
    int addCare(int roomId,int userId);
    
    int careNum(int roomId);

    int isCare(int userId,int roomId);
    
    int deleteCare(int userId,int roomId);
}
