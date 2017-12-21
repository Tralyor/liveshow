package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.dto.manager.DarkroomByModuleDTO;
import org.liveshow.entity.DarkroomRoom;
import org.liveshow.service.DarkroomRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Cjn on 2017/11/30.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DarkroomRoomServiceImpl {
    @Autowired
    private DarkroomRoomService darkroomRoomService;
    
    @Test
    public void insertDark(){
        darkroomRoomService.insertDarkRecord(1,"涉黄",30*24*60,"xxxxx",2);
    }

    @Test
    public void getNumByModule()
	{
		List<DarkroomByModuleDTO> darkroomByModuleDTOList =
				darkroomRoomService.getNumByModule();
		for (DarkroomByModuleDTO d : darkroomByModuleDTOList)
		{
			System.out.println(d.getName() + ", " + d.getValue());
		}
	}
}
