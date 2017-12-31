package org.liveshow.service;

import org.liveshow.dto.PersonalApplicationDTO;
import org.liveshow.dto.Show;
import org.liveshow.entity.CombinationEntity.ApplicationInfo;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface ApplicationService {

    /**
     * 根据日期获取申请记录
     * @param startTime
     * @param endTime
     * @return
     */
    Show getApplicationByDate(Integer startTime, Integer endTime);

    /**
     * 更新申请状态
     * @param id
     * @param passState
     * @param managerId
     * @return
     */
    Show checkApplication(int id, Boolean passState, int managerId);

    List<PersonalApplicationDTO> initApplication();

	/**
	 * 加入新的审核
	 * @param personalApplicationDTO
	 * @return
	 */
    boolean addApplication(PersonalApplicationDTO personalApplicationDTO);

    Boolean checkApplication(int uid);
}
