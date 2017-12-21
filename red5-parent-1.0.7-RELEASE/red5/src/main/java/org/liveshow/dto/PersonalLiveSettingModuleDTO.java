package org.liveshow.dto;

/**
 * Created by asus on 2017/12/9.
 */
public class PersonalLiveSettingModuleDTO
{
	private int moduleId;

	private String moduleName;

	@Override
	public String toString()
	{
		return "PersonalLiveSettingModuleDTO{" + "moduleId=" + moduleId + ", moduleName='" + moduleName + '\'' + '}';
	}

	public PersonalLiveSettingModuleDTO()
	{
	}

	public PersonalLiveSettingModuleDTO(int moduleId, String moduleName)
	{
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}

	public int getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(int moduleId)
	{
		this.moduleId = moduleId;
	}

	public String getModuleName()
	{
		return moduleName;
	}

	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}
}
