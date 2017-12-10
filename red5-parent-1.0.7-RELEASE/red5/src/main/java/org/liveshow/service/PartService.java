package org.liveshow.service;

import org.liveshow.dto.Show;
import org.liveshow.entity.Part;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface PartService {

    /**
     * 获取所有板块
     * @return
     */
    List<Part> getAllPart();

    List<Part> findAllPart();

    /**
     * 修改板块名称
     * @param id
     * @param name
     * @return
     */
    Show updatePart(int id, String name);

    /**
     * 移除板块
     * @param id
     * @return
     */
    Show movePart(int id);

    /**
     * 添加板块
     * @param name
     * @return
     */
    Show addPart(String name);
    
    Part findPartById(int partId);
}
