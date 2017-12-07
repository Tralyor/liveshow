package org.liveshow.service.impl;

import org.liveshow.dao.RecommendModuleMapper;
import org.liveshow.entity.CombinationEntity.RecommendModulAndInfo;
import org.liveshow.entity.Module;
import org.liveshow.entity.RecommendModule;
import org.liveshow.service.RecommendModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class RecommendModuleServiceImpl implements RecommendModuleService {

    @Autowired
    private RecommendModuleMapper recommendModuleMapper;
    
    @Override
    @Transactional
    public int handleRecommendModule(int id, String moduleId) {
        int status = recommendModuleMapper.confirmById(id);
        if (moduleId.equals("empty")){
            if(status == 0){
                return 0;
            }else{
                recommendModuleMapper.deleteByPrimaryKey(id);
                return 0;
            }
        }else{
            int moduleIdNumber = Integer.parseInt(moduleId);
            if (status == 0){
                RecommendModule recommendModule = new RecommendModule();
                recommendModule.setId(id);
                recommendModule.setModuleId(moduleIdNumber);
                if (id < 4){
                    recommendModule.setType(false);
                }else{
                    recommendModule.setType(true);
                }
                recommendModule.setRecoTime((int) System.currentTimeMillis());
                return recommendModuleMapper.insert(recommendModule);
            }else{
                return recommendModuleMapper.updateById(id, moduleIdNumber, (int) System.currentTimeMillis());
            }
        }
    }

    @Override
    @Transactional
    public List<RecommendModule> getAllRecommendModule() {
        return recommendModuleMapper.selectModulePresent();
    }

    /**
     * @Author cjn
     * @return List<Module> limit 3
     */
    @Override
    @Transactional
    public List<RecommendModulAndInfo> findRecoModul() {
        List<RecommendModulAndInfo> lists =  recommendModuleMapper.findRecoModule();
        if (lists == null || lists.size() == 0){
            return null;
        }
        return lists;
    }
}
