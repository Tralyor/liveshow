package org.liveshow.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.liveshow.entity.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by asus on 2017/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class PartMapperTest
{
	@Autowired
	private PartMapper partMapper;
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void selectAllWithModuleList() throws Exception
	{
		List<Part> partList = partMapper.selectAllWithModuleList();
		for (Part p : partList)
		{
			System.out.println(mapper.writeValueAsString(p));
		}
	}

}
