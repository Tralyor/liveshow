package org.liveshow.service;

import java.util.List;

import org.liveshow.dto.PersonalLiveSettingDTO;
import org.liveshow.dto.Show;
import org.liveshow.entity.CombinationEntity.RoomAndOwner;
import org.liveshow.entity.Room;

/**
 * Created by Cjn on 2017/11/28.
 */
public interface RoomService {
    
    List<Room> findAllRoom();
    
    List<RoomAndOwner> findRecoRoom(int recoModule, int pageNo, int pageSize);
    
    RoomAndOwner findRoomByIdWidhtOnwer(int roomId);
    
    Room findRoomById(int roomId);
    
    int changeRoomState(int roomId,int state);
    
    void changeMostPop(int roomId);

	/**
	 * 获得直播设置信息
	 * @param userId
	 * @return
	 */
	PersonalLiveSettingDTO getPersonalLiveSetting(int userId);

	/**
	 * ajax
	 * 更新直播设置
	 * @param personalLiveSettingDTO
	 * @return
	 */
	Show updateLiveSetting(PersonalLiveSettingDTO personalLiveSettingDTO);


}
