package org.liveshow.dto.manager;

/**
 * Created by asus on 2017/12/11.
 */
public class SuperManagerDTO
{
	private int managerId;
	private String loginName;
	private String realName;
	private String moduleName;
	private String idNum;
	private String tel;
	private String address;
	private int roomNum;
	private String falseProportion;

	@Override
	public String toString()
	{
		return "SuperManagerDTO{" + "managerId=" + managerId + ", loginName='" + loginName + '\'' + ", realName='"
				+ realName + '\'' + ", moduleName='" + moduleName + '\'' + ", idNum='" + idNum + '\'' + ", tel='" + tel
				+ '\'' + ", address='" + address + '\'' + ", roomNum=" + roomNum + ", falseProportion='"
				+ falseProportion + '\'' + '}';
	}

	public SuperManagerDTO()
	{
	}

	public SuperManagerDTO(int managerId, String loginName, String realName, String moduleName, String idNum,
			String tel, String address, int roomNum, String falseProportion)
	{
		this.managerId = managerId;
		this.loginName = loginName;
		this.realName = realName;
		this.moduleName = moduleName;
		this.idNum = idNum;
		this.tel = tel;
		this.address = address;
		this.roomNum = roomNum;
		this.falseProportion = falseProportion;
	}

	public int getManagerId()
	{
		return managerId;
	}

	public void setManagerId(int managerId)
	{
		this.managerId = managerId;
	}

	public String getLoginName()
	{
		return loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
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

	public String getFalseProportion()
	{
		return falseProportion;
	}

	public void setFalseProportion(String falseProportion)
	{
		this.falseProportion = falseProportion;
	}
}
