package org.liveshow.service.impl;

import org.liveshow.dao.CareMapper;
import org.liveshow.entity.Care;
import org.liveshow.entity.CareExample;
import org.liveshow.service.CareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class CareServiceImpl implements CareService {
    
    @Autowired
    private CareMapper careMapper;


    /**
     *@Author Cjn
     * @param roomId
     * @param userId
     * @return res
     *插入关注 首先先查看是否关注过 
     */
    @Override
    @Transactional
    public int addCare(int roomId, int userId) {
        Care care = new Care();
        if (roomId == 0 || userId == 0 ||isCare(userId,roomId) == 1){
            return 0;
        }
        care.setRoomId(roomId);
        care.setUserId(userId);
        care.setTime(Integer.parseInt(String.valueOf(System.currentTimeMillis()/1000)));
        int res = careMapper.insert(care);
        return res;
    }


    /**
     * @Author Cjn
     * @param roomId
     * @return res
     * 返回房间的关注数
     */
    @Override
    @Transactional
    public int careNum(int roomId) {
        CareExample careExample = new CareExample();
        CareExample.Criteria criteria = careExample.createCriteria();
        criteria.andRoomIdEqualTo(roomId);
        int res = careMapper.countByExample(careExample);
        return res;
    }

    /**
     * @Author Cjn
     * @param userId
     * @param roomId
     * @return res
     * 返回用户是否已经关注过该主播
     */
    @Override
    @Transactional
    public int isCare(int userId, int roomId) {
        CareExample careExample = new CareExample();
        CareExample.Criteria criteria = careExample.createCriteria();
        if (userId == 0 || roomId ==0){
            return 0;
        }
        criteria.andRoomIdEqualTo(roomId);
        criteria.andUserIdEqualTo(userId);
        List<Care>  lists  = careMapper.selectByExample(careExample);
        if (lists == null ||lists.size() == 0){
            return 0;
        }
        return 1;
    }

    /**
     * @Author Cjn
     * @param userId
     * @param roomId
     * @return res
     *用户取消关注
     */
    @Override
    @Transactional
    public int deleteCare(int userId, int roomId) {
        CareExample careExample = new CareExample();
        CareExample.Criteria criteria = careExample.createCriteria();
        if (userId == 0 || roomId ==0){
            return 0;
        }
        criteria.andRoomIdEqualTo(roomId);
        criteria.andUserIdEqualTo(userId);
        int res = careMapper.deleteByExample(careExample);
        return res;
    }
}
