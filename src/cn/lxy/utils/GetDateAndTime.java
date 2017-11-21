package cn.lxy.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="getDateAndTime")
@Scope(value="prototype")
public class GetDateAndTime {
	
	private Date date = new Date();
	private DateFormat dateFormat;

	public String getNowDate(){
		dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	public String getNowTime() {
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(date);		
	}
	public String getStandardDateAndTime() {
		dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		return dateFormat.format(date);
	}
	
	public int getFebruaryDays(int year) {
		if(year%100==0) {
			if(year%400==0) {
				return 29;
			}else {
				return 28;
			}
		}else if(year%4==0){
			return 29;
		}else {
			return 28;
		}
	}
	
	
	
}
