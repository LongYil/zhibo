package cn.lxy.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest6 {

	public static void main(String[] args) {
//		System.out.println(new SimpleDateFormat("YYYYMMddHHmmss").format(new Date()));
		String a = "temp.jsp";
		String temp[] = a.split("\\.");
		System.out.println(temp[0]);
		System.out.println(temp[1]);
		
	}

}
