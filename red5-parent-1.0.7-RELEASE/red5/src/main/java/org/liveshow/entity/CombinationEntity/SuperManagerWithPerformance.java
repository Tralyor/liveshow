package org.liveshow.entity.CombinationEntity;

import org.liveshow.entity.User;

/**
 * Created by asus on 2017/12/11.
 */
public class SuperManagerWithPerformance
{
	private int managerId;
	private String realName;
	private String loginName;
	private int moduleId;
	private String moduleName;
	private String idNum;
	private String tel;
	private String address;
	private int roomNum;
	private int falseRoomNum;

	@Override
	public String toString()
	{
		return "SuperManagerWithPerformance{" + "managerId=" + managerId + ", realName='" + realName + '\''
				+ ", loginName='" + loginName + '\'' + ", moduleId=" + moduleId + ", moduleName='" + moduleName + '\''
				+ ", idNum='" + idNum + '\'' + ", tel='" + tel + '\'' + ", address='" + address + '\'' + ", roomNum="
				+ roomNum + ", falseRoomNum=" + falseRoomNum + '}';
	}

	public SuperManagerWithPerformance()
	{
	}

	public SuperManagerWithPerformance(int managerId, String realName, String loginName, int moduleId,
			String moduleName, String idNum, String tel, String address, int roomNum, int falseRoomNum)
	{
		this.managerId = managerId;
		this.realName = realName;
		this.loginName = loginName;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
		this.idNum = idNum;
		this.tel = tel;
		this.address = address;
		this.roomNum = roomNum;
		this.falseRoomNum = falseRoomNum;
	}

	public int getManagerId()
	{
		return managerId;
	}

	public void setManagerId(int managerId)
	{
		this.managerId = managerId;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getLoginName()
	{
		return loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
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

	public String getIdNum()
	{
		return idNum;
	}

	public void setIdNum(String idNum)
	{
		this.idNum = idNum;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public int getRoomNum()
	{
		return roomNum;
	}

	public void setRoomNum(int roomNum)
	{
		this.roomNum = roomNum;
	}

	public int getFalseRoomNum()
	{
		return falseRoomNum;
	}

	public void setFalseRoomNum(int falseRoomNum)
	{
		this.falseRoomNum = falseRoomNum;
	}
}
