package org.liveshow.dto;

import java.util.Date;

public class PersonalApplicationDTO
{
	private int id;
	private int userId;
	private String realName;
	private String nickName;
	private String passportType;
	private String idcardId;
	private String headheldPassport;
	private String passportFront;
	private String passportBack;
	private String applyTime;
	private Boolean passState;
	private Integer managerId;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	public String getPassportType()
	{
		return passportType;
	}

	public void setPassportType(String passportType)
	{
		this.passportType = passportType;
	}

	public String getIdcardId()
	{
		return idcardId;
	}

	public void setIdcardId(String idcardId)
	{
		this.idcardId = idcardId;
	}

	public String getHeadheldPassport()
	{
		return headheldPassport;
	}

	public void setHeadheldPassport(String headheldPassport)
	{
		this.headheldPassport = headheldPassport;
	}

	public String getPassportFront()
	{
		return passportFront;
	}

	public void setPassportFront(String passportFront)
	{
		this.passportFront = passportFront;
	}

	public String getPassportBack()
	{
		return passportBack;
	}

	public void setPassportBack(String passportBack)
	{
		this.passportBack = passportBack;
	}

	public String getApplyTime()
	{
		return applyTime;
	}

	public void setApplyTime(String applyTime)
	{
		this.applyTime = applyTime;
	}

	public Boolean getPassState()
	{
		return passState;
	}

	public void setPassState(Boolean passState)
	{
		this.passState = passState;
	}

	public Integer getManagerId()
	{
		return managerId;
	}

	public void setManagerId(Integer managerId)
	{
		this.managerId = managerId;
	}
}
