package org.liveshow.service;

import org.liveshow.entity.Module;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface ModuleService {
    List<Module> findModuleByPartId(int typeNum);
}
