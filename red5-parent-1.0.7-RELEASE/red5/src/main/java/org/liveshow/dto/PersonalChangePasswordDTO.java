package org.liveshow.dto;

/**
 * Created by asus on 2017/12/5.
 */
public class PersonalChangePasswordDTO
{
	private String oldPass;
	private String newPass;
	private String confirmPass;

	@Override
	public String toString()
	{
		return "PersonalChangePasswordDTO{" + "oldPass='" + oldPass + '\'' + ", newPass='" + newPass + '\''
				+ ", confirmPass='" + confirmPass + '\'' + '}';
	}

	public String getOldPass()
	{
		return oldPass;
	}

	public void setOldPass(String oldPass)
	{
		this.oldPass = oldPass;
	}

	public String getNewPass()
	{
		return newPass;
	}

	public void setNewPass(String newPass)
	{
		this.newPass = newPass;
	}

	public String getConfirmPass()
	{
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass)
	{
		this.confirmPass = confirmPass;
	}
}
