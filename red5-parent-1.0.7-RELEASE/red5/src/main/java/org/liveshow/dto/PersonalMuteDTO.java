package org.liveshow.dto;

/**
 * Created by asus on 2017/12/8.
 */
public class PersonalMuteDTO
{
	private int darkroomId;

	private String muteName;

	private String danmaContent;

	private String time;

	private String hours;

	@Override
	public String toString()
	{
		return "PersonalMuteDTO{" + "darkroomId=" + darkroomId + ", muteName='" + muteName + '\'' + ", danmaContent='"
				+ danmaContent + '\'' + ", time='" + time + '\'' + ", hours='" + hours + '\'' + '}';
	}

	public PersonalMuteDTO()
	{
	}

	public PersonalMuteDTO(int darkroomId, String muteName, String danmaContent, String time, String hours)
	{
		this.darkroomId = darkroomId;
		this.muteName = muteName;
		this.danmaContent = danmaContent;
		this.time = time;
		this.hours = hours;
	}

	public int getDarkroomId()
	{
		return darkroomId;
	}

	public void setDarkroomId(int darkroomId)
	{
		this.darkroomId = darkroomId;
	}

	public String getMuteName()
	{
		return muteName;
	}

	public void setMuteName(String muteName)
	{
		this.muteName = muteName;
	}

	public String getDanmaContent()
	{
		return danmaContent;
	}

	public void setDanmaContent(String danmaContent)
	{
		this.danmaContent = danmaContent;
	}

	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}

	public String getHours()
	{
		return hours;
	}

	public void setHours(String hours)
	{
		this.hours = hours;
	}
}
