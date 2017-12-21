package org.liveshow.dto;

import java.util.List;

/**
 * Created by asus on 2017/12/9.
 */
public class PersonalLiveSettingPartDTO
{
	private int partId;

	private String partName;

	private List<PersonalLiveSettingModuleDTO> moduleDTOList;

	@Override
	public String toString()
	{
		return "PersonalLiveSettingPartDTO{" + "partId=" + partId + ", partName='" + partName + '\''
				+ ", moduleDTOList=" + moduleDTOList + '}';
	}

	public PersonalLiveSettingPartDTO()
	{
	}

	public PersonalLiveSettingPartDTO(int partId, String partName, List<PersonalLiveSettingModuleDTO> moduleDTOList)
	{
		this.partId = partId;
		this.partName = partName;
		this.moduleDTOList = moduleDTOList;
	}

	public int getPartId()
	{
		return partId;
	}

	public void setPartId(int partId)
	{
		this.partId = partId;
	}

	public String getPartName()
	{
		return partName;
	}

	public void setPartName(String partName)
	{
		this.partName = partName;
	}

	public List<PersonalLiveSettingModuleDTO> getModuleDTOList()
	{
		return moduleDTOList;
	}

	public void setModuleDTOList(List<PersonalLiveSettingModuleDTO> moduleDTOList)
	{
		this.moduleDTOList = moduleDTOList;
	}
}
