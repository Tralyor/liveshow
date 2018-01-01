package org.liveshow.util;

import java.util.HashMap;

/**
 * Created by asus on 2017/12/8.
 */
public class TimeEnum
{
	private static HashMap<Integer, String> time2StringMap;

	static
	{
		time2StringMap = new HashMap<>();
		time2StringMap.put(60, "1分钟");
		time2StringMap.put(600, "10分钟");
		time2StringMap.put(1800, "30分钟");
		time2StringMap.put(3600, "1小时");
		time2StringMap.put(43200, "12小时");
		time2StringMap.put(86400, "1天");
		time2StringMap.put(172800, "2天");
		time2StringMap.put(259200, "3天");
		time2StringMap.put(604800, "7天");
		time2StringMap.put(2592000, "30天");
	}

	public static String time2String(int time)
	{
		return time2StringMap.get(time);
	}
}
