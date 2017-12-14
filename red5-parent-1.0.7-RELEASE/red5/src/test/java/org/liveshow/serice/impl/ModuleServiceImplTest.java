package org.liveshow.serice.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.entity.Module;
import org.liveshow.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Cjn on 2017/11/29.
 */
@ContextConfiguration("classpath:spring/spring-*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ModuleServiceImplTest {
    @Autowired 
    private ModuleService moduleService;
    
    @Test
    public void findModuleType(){
        moduleService.findModuleByPartId(1);
    }

    @Test
    public void getAllModule()
	{
		List<Module> moduleList = moduleService.getAllModule();
		for (Module m : moduleList)
		{
			System.out.println(m.getName());
		}
	}
}
