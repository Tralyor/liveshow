package org.liveshow.service;

import org.liveshow.entity.RecommendModule;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface RecommendModuleService {

    /**
     * 处理推荐模块提交的表单
     * @param id
     * @param moduleId
     * @return
     */
    int handleRecommendModule(int id, String moduleId);

    /**
     * 获取当前所存储的推荐模块
     * @return
     */
    List<RecommendModule> getAllRecommendModule();
}
