package org.liveshow.service;

import org.liveshow.dto.Show;
import org.liveshow.entity.Module;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface ModuleService {

    /**
     * 获取所有模块信息
     * @return
     */
    List<Module> getAllModule();

    Show getModuleAndPart();

    List<Module> findModuleByPartId(int typeNum);

    /**
     * 添加模块
     * @param partId
     * @param name
     * @param description
     * @param photo
     * @return
     */
    Show addModule(int partId, String name, String description, String photo);

    /**
     * 模块图片上传至服务器
     * @param stream
     * @param path
     * @param file
     */
    void savepic(InputStream stream, String path, String file);

    /**
     * 修改模块名称
     * @param id
     * @param name
     * @return
     */
    Show changeModuleName(int id, String name);

    /**
     * 修改模块描述信息
     * @param id
     * @param description
     * @return
     */
    Show changeModuleDescription(int id, String description);

    /**
     * 修改模块图片信息
     * @param id
     * @param photo
     * @return
     */
    Show changeModulePhoto(int id, String photo);

    /**
     * 移除模块
     * @param id
     * @return
     */
    Show moveModule(int id);

    
    Module findModuleById(int moduleId);
}
