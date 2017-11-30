package org.liveshow.service.impl;

import org.liveshow.dao.ModuleMapper;
import org.liveshow.entity.Module;
import org.liveshow.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
