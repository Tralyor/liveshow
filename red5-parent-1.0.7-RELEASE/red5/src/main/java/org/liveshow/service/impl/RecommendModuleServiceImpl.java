package org.liveshow.service.impl;

import org.liveshow.dao.RecommendModuleMapper;
import org.liveshow.entity.Module;
import org.liveshow.entity.RecommendModule;
import org.liveshow.service.RecommendModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class RecommendModuleServiceImpl implements RecommendModuleService {

    @Autowired
    private RecommendModuleMapper recommendModuleMapper;
    /**
     * @Author cjn
     * @return List<Module> limit 3
     */
    @Override
    public List<Module> findRecoModul() {
        List<Module> lists =  recommendModuleMapper.findRecoModule();
        if (lists == null || lists.size() == 0){
            return null;
        }
        return lists;
    }
}
