package org.liveshow.service.impl;

import org.liveshow.dao.RoomMapper;
import org.liveshow.dto.PersonalLiveSettingDTO;
import org.liveshow.entity.CombinationEntity.RoomAndOwner;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.entity.Room;
import org.liveshow.entity.RoomExample;
import org.liveshow.service.RoomService;
import org.liveshow.surveillant.RoomPopularity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class RoomeServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    /**
     * @Author cjn
     * @return list 所有的房间信息
     */
    @Override
    @Transactional
    public List<Room> findAllRoom() {
        RoomExample roomExample = new RoomExample();
        List<Room> list =  roomMapper.selectByExample(roomExample);
        if (list == null || list.size() == 0){
            return null;
        }else
            return list;
    }

    /**
     * @Author Cjn
      * @param recoModule
     * @return lists
     */
    @Override
    @Transactional
    public List<RoomAndOwner> findRecoRoom(int recoModule, int pageNo, int pageSize) {
        List<RoomAndOwner> lists = roomMapper.findRecoRoom(recoModule,pageNo,pageSize);
        if (lists  == null || lists.size() == 0){
            return null;
        }
        return lists;
    }

    @Override
    @Transactional
    public RoomAndOwner findRoomByIdWidhtOnwer(int roomId) {
        return roomMapper.findRoomById(roomId);
    }

    @Override
    @Transactional
    public Room findRoomById(int roomId) {
        RoomExample roomExample = new RoomExample();
        RoomExample.Criteria criteria = roomExample.createCriteria();
        criteria.andIdEqualTo(roomId);
        List<Room> rooms = roomMapper.selectByExample(roomExample);
        if (rooms == null || rooms.size()!= 1){
            return null;
        }
        return rooms.get(0);
    }

    @Override
    public int changeRoomState(int roomId, int state) {
        Room room = findRoomById(roomId);
        if (state == 0)
            room.setSwitchJudge(false);
        else
            room.setSwitchJudge(true);
        roomMapper.updateByPrimaryKeySelective(room);
        return 0;
    }

    @Override
    public void changeMostPop(int roomId) {
        Room  room = roomMapper.selectByPrimaryKey(roomId);
        RoomPopularity roomPopularity = RoomPopularity.getInstance();
        int people = roomPopularity.getRoomIdAndPopularity().get(roomId).getGetPopulartyMax();
        if (room.getMostPopular() < people) {
            room.setMostPopular(people);
            roomMapper.updateByPrimaryKey(room);
        }
    }

	@Override
	public PersonalLiveSettingDTO getPersonalLiveSetting(int userId)
	{
		Room room = roomMapper.selectByUserIdWithModule(userId);
		return entity2PersonalLiveSettingDTO(room);
	}

	private PersonalLiveSettingDTO entity2PersonalLiveSettingDTO(Room room)
	{
		Module module = room.getModule();
		Part part = module.getPart();
		return new PersonalLiveSettingDTO(room.getId(), room.getName(),
				room.getNotice(), "",
				room.getStreamCode(), room.getPhoto(),
				part.getId(), part.getName(),
				module.getId(), module.getName(),
				room.getSwitchJudge());
	}
}
