package org.liveshow.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Cjn on 2017/11/30.
 */
public class TimeTool
{
    public static String getDateFormat(long timestamp, String type){
        SimpleDateFormat ft = new SimpleDateFormat (type);
        String d = ft.format(timestamp * 1000);
        return d;
    }
    public static Date StringToDate(int timestamp,String type) throws ParseException {
        SimpleDateFormat ft = new SimpleDateFormat(type);
        String d = ft.format(timestamp);
        Date date = ft.parse(d);
        return date;
    }
    
}
