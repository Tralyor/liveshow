package org.liveshow.dto.manager;

/**
 * Created by asus on 2017/12/11.
 */
public class ModuleDTO
{
	private int moduleId;
	private String moduleName;

	@Override
	public String toString()
	{
		return "ModuleDTO{" + "moduleId=" + moduleId + ", moduleName='" + moduleName + '\'' + '}';
	}

	public ModuleDTO()
	{
	}

	public ModuleDTO(int moduleId, String moduleName)
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
