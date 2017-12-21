package org.liveshow.dto;

import java.util.Date;

/**
 * Created by asus on 2017/12/6.
 */
public class PersonalLiveRecordDTO
{
	private String startTime;
	private String endTime;
	//分钟为单位
	private int duration;

	@Override
	public String toString()
	{
		return "PersonalLiveRecordDTO{" + "startTime='" + startTime + '\'' + ", endTime='" + endTime + '\''
				+ ", duration=" + duration + '}';
	}

	public PersonalLiveRecordDTO(String startTime, String endTime, int duration)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

	public int getDuration()
	{
		return duration;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}
}
