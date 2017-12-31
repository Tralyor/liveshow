package org.liveshow.service.impl;

import org.liveshow.dao.ModuleMapper;
import org.liveshow.dao.PartMapper;
import org.liveshow.dao.RecommendModuleMapper;
import org.liveshow.dto.Show;
import org.liveshow.entity.CombinationEntity.RecommendModulePresent;
import org.liveshow.entity.CombinationEntity.RecommendModulAndInfo;
import org.liveshow.entity.Module;
import org.liveshow.entity.RecommendModule;
import org.liveshow.service.RecommendModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class RecommendModuleServiceImpl implements RecommendModuleService {

    @Autowired
    private RecommendModuleMapper recommendModuleMapper;

    @Autowired
    private PartMapper partMapper;

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    @Transactional
    public Show handleRecommendModule(int id, String moduleId) {
        Show show = new Show();
        Boolean type;
        if (id < 7){
            type = false;
        }else{
            type = true;
        }

        int status = recommendModuleMapper.confirmById(id);
        if (moduleId.equals("empty")){
            if(recommendModuleMapper.confirmById(id) == 0){
                show.setState(0);
                show.setMessage("禁止上传空的模块！");
            }else{
                recommendModuleMapper.deleteByPrimaryKey(id);
                show.setState(1);
                show.setMessage("已将原模块取消");
            }
        }else{
            int moduleIdNumber = Integer.parseInt(moduleId);
            if(recommendModuleMapper.confirmModule(moduleIdNumber, type, id) != 0){
                show.setState(0);
                show.setMessage("该模块已经存在于推荐模块中");
            }else {
                if (recommendModuleMapper.confirmById(id) == 0){
                    RecommendModule recommendModule = new RecommendModule();
                    recommendModule.setId(id);
                    recommendModule.setModuleId(moduleIdNumber);
                    recommendModule.setType(type);
                    recommendModule.setRecoTime((int) System.currentTimeMillis());
                    recommendModuleMapper.insert(recommendModule);
                }else{
                    recommendModuleMapper.updateById(id, moduleIdNumber, (int) System.currentTimeMillis());
                }
                show.setState(1);
                show.setMessage("推荐模块已更新");
            }
        }
        return show;
    }

    @Override
    @Transactional
    public Show getAllRecommendModule() {
        List<RecommendModulePresent> recommendModulePresents = recommendModuleMapper.selectModulePresent();
        Show show = new Show();
        show.setMessage("获取信息成功");
        show.setState(1);
        show.setData(recommendModulePresents);
        return show;
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
