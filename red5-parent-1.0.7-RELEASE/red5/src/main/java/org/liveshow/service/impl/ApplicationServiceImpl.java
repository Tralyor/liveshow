package org.liveshow.service.impl;

import org.liveshow.dao.AnchorMapper;
import org.liveshow.dao.ApplicationMapper;
import org.liveshow.dao.RoomMapper;
import org.liveshow.dao.UserMapper;
import org.liveshow.dto.PersonalApplicationDTO;
import org.liveshow.dto.Show;
import org.liveshow.entity.Anchor;
import org.liveshow.entity.Application;
import org.liveshow.entity.CombinationEntity.ApplicationInfo;
import org.liveshow.entity.Room;
import org.liveshow.service.ApplicationService;
import org.liveshow.util.TimeTool;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AnchorMapper anchorMapper;

    @Autowired
    private RoomMapper roomMapper;

    @Override
    @Transactional
    public Show getApplicationByDate(Integer startTime, Integer endTime) {
        Show show = new Show();
        if(startTime == null){
            startTime = Integer.MIN_VALUE;
        }
        if (endTime == null){
            endTime = Integer.MAX_VALUE;
        }
        List<ApplicationInfo> applicationInfos = applicationMapper.selectApplication(startTime, endTime);
        show.setData(applicationInfos);
        show.setState(1);
        show.setMessage("申请记录");
        return show;
    }

    @Override
    @Transactional
    public Show checkApplication(int id, Boolean passState, int managerId) {
        Show show = new Show();
        try
		{
			applicationMapper.updateApplicationInfo(id, passState, managerId);
			Application application = applicationMapper.selectByPrimaryKey(id);
			userMapper.updateTypeById(application.getUserId(), 1);
			Anchor anchor = new Anchor();
			anchor.setIdcardId(application.getIdcardId());
			anchor.setUserId(application.getUserId());
			anchor.setName(application.getRealName());
			anchor.setIdcardPhoto(application.getIdcardPhoto());
			anchor.setTelephone(application.getTelephone());
			anchorMapper.insert(anchor);
			Room room = new Room();
			room.setUserId(application.getUserId());
			room.setSwitchJudge(false);
			room.setMostPopular(0);
			roomMapper.insert(room);
			show.setState(1);
			show.setMessage("操作成功");

			return show;
		}
		catch (RuntimeException e)
		{
			return new Show(null, 0, "操作失败");
		}
    }

    @Override
    @Transactional
    public List<PersonalApplicationDTO> initApplication() {
    	String format = "yyyy-MM-dd HH:mm";
    	List<ApplicationInfo> applicationInfoList = applicationMapper.selectApplication(Integer.MIN_VALUE, Integer.MAX_VALUE);
    	List<PersonalApplicationDTO> personalApplicationDTOList = new ArrayList<>();
		for (ApplicationInfo info : applicationInfoList)
		{
			PersonalApplicationDTO tmp = new PersonalApplicationDTO();
			BeanUtils.copyProperties(info, tmp);
			tmp.setApplyTime(TimeTool.getDateFormat(info.getApplyTime(), format));
			String[] nameArray = info.getIdcardPhoto().split(";");
			tmp.setHeadheldPassport(nameArray[0]);
			tmp.setPassportFront(nameArray[1]);
			tmp.setPassportBack(nameArray[2]);

			personalApplicationDTOList.add(tmp);
		}
        return personalApplicationDTOList;
    }

	@Override
	public boolean addApplication(PersonalApplicationDTO personalApplicationDTO)
	{
		Application application = new Application();
		BeanUtils.copyProperties(personalApplicationDTO, application);
		application.setIdcardPhoto(personalApplicationDTO.getHeadheldPassport() + ";"
				 + personalApplicationDTO.getPassportFront() + ";"
				 + personalApplicationDTO.getPassportBack());
		application.setApplyTime((int)(System.currentTimeMillis() / 1000));
		int res = applicationMapper.insertSelective(application);
		if (res != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public Boolean checkApplication(int uid)
	{
		return applicationMapper.selectPassStateByUserId(uid);
	}
}
