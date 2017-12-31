package org.liveshow.service;

import org.liveshow.dto.Show;
import org.liveshow.dto.manager.SuperManagerDTO;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface SupermanagerService {

	/**
	 * 获取所有超管的数据
	 * @return
	 */
	List<SuperManagerDTO> getAllSuperManager();

	/**
	 * 根据id获取超管
	 * @param moduleId
	 * @return
	 */
	Show getSuperManagerByModuleId(int moduleId);

	/**
	 * 添加超管
	 * @param loginName
	 * @return
	 */
	Show addSuperManager(String loginName, int moduleId);

	/**
	 * 更改超管的管理板块
	 * @param loginName
	 * @param moduleId
	 * @return
	 */
	Show changeSuperManager(String loginName, int moduleId);

	/**
	 * 取消某个超管
	 * @param loginName
	 * @return
	 */
	Show canelSuperManager(String loginName);
}
