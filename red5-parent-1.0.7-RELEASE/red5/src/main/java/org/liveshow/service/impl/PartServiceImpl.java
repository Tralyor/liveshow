package org.liveshow.service.impl;

import org.junit.Test;
import org.liveshow.dao.PartMapper;
import org.liveshow.dto.PersonalLiveSettingModuleDTO;
import org.liveshow.dto.PersonalLiveSettingPartDTO;
import org.liveshow.entity.Module;
import org.liveshow.entity.Part;
import org.liveshow.entity.PartExample;
import org.liveshow.service.PartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cjn on 2017/11/28.
 */
@Service
public class PartServiceImpl implements PartService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PartMapper partMapper;

    @Override
    @Transactional
    public List<Part> getAllPart() {
        return partMapper.selectAll();
    }

    @Override
    @Transactional
    public List<Part> findAllPart() {
        PartExample partExample = new PartExample();
        List<Part> lists = partMapper.selectByExample(partExample);
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return lists;
    }

    @Override
    @Transactional
    public Part findPartById(int partId) {
        PartExample partExample = new PartExample();
        PartExample.Criteria criteria = partExample.createCriteria();
        criteria.andIdEqualTo(partId);
        List<Part> lists = partMapper.selectByExample(partExample);
        if (lists == null || lists.size() != 1) {
            return null;
        }
        return lists.get(0);
    }

	@Override
	public List<PersonalLiveSettingPartDTO> getAllPartWithModuleList()
	{
		logger.info("获取所有板块及其所有模块");
		List<Part> partList = partMapper.selectAllWithModuleList();
		return entityList2PersonalLiveSettingPartDTOList(partList);
	}

	private List<PersonalLiveSettingPartDTO> entityList2PersonalLiveSettingPartDTOList(
			List<Part> partList)
	{
		List<PersonalLiveSettingPartDTO> personalLiveSettingPartDTOList = new ArrayList<>();
		for (Part p : partList)
		{
			personalLiveSettingPartDTOList.add(entity2PersonalLiveSettingPartDTO(p));
		}
		return personalLiveSettingPartDTOList;
	}

	private PersonalLiveSettingPartDTO entity2PersonalLiveSettingPartDTO(Part part)
	{
		return new PersonalLiveSettingPartDTO(part.getId(), part.getName(),
				moduleEntityList2PersonalLiveSettingModuleDTOList(part.getModuleList()));
	}

	private List<PersonalLiveSettingModuleDTO> moduleEntityList2PersonalLiveSettingModuleDTOList(
			List<Module> moduleList)
	{
		List<PersonalLiveSettingModuleDTO> personalLiveSettingModuleDTOList = new ArrayList<>();
		for (Module m : moduleList)
		{
			personalLiveSettingModuleDTOList.add(moduleEntity2PersonalLiveSettingModuleDTO(m));
		}
		return personalLiveSettingModuleDTOList;
	}

	private PersonalLiveSettingModuleDTO moduleEntity2PersonalLiveSettingModuleDTO(Module module)
	{
		return new PersonalLiveSettingModuleDTO(module.getId(), module.getName());
	}
}
