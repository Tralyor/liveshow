package org.liveshow.service;

import org.liveshow.dto.PersonalLiveSettingPartDTO;
import org.liveshow.entity.Part;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface PartService {

    List<Part> getAllPart();

    List<Part> findAllPart();
    
    Part findPartById(int partId);

	/**
	 * 获取所有板块
	 * 并且获取板块所拥有的module
	 * @return
	 */
	List<PersonalLiveSettingPartDTO> getAllPartWithModuleList();
}
