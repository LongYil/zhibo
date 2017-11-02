package cn.lxy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyTest2 {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		long time = format.parse("2017-11-30 23:59:59").getTime()/1000;
		
//		long time = System.currentTimeMillis();
//		System.out.println(time);
//        String nowTimeStamp = String.valueOf(time / 1000);
//        System.out.println(nowTimeStamp);
        System.out.println(time);
        String t =  Long.toHexString(time);
        t.toUpperCase();
        System.out.println(t);
	}

}
