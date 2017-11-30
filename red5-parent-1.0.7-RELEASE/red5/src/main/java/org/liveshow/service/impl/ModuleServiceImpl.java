package org.liveshow.service.impl;

import org.bouncycastle.math.raw.Mod;
import org.liveshow.dao.ModuleMapper;
import org.liveshow.entity.Module;
import org.liveshow.entity.ModuleExample;
import org.liveshow.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class ModuleServiceImpl  implements ModuleService{

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public List<Module> getAllModule() {
        return moduleMapper.selectAll();
    }
    
    @Override
    @Transactional
    public List<Module> findModuleByPartId(int typeNum) {
        List<Module> lists = moduleMapper.findByPart(typeNum);
        if (lists == null || lists.size() ==0){
            return null;
        }
        return lists;
    }

    @Override
    @Transactional
    public Module findModuleById(int moduleId) {
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andIdEqualTo(moduleId);
        List<Module> lists = moduleMapper.selectByExample(moduleExample);
        if (lists == null || lists.size()!=1){
            return  null;
        }
        
        return lists.get(0);
    }


}
