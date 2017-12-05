package cn.lxy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.po.Course;
import cn.lxy.vo.CourseVo;

@Component(value="dateUtils")
public class DateUtils {
	private CourseVo coursevo;
	public List<CourseVo> formatDateTime(List<Course> list){
		List<CourseVo> templist = new ArrayList<CourseVo>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		for(int i=0;i<list.size();i++) {
			coursevo = new CourseVo();
			coursevo.setCourse(list.get(i));
			coursevo.setTime(sdf.format(list.get(i).getTime()));
			templist.add(coursevo);
		}
		return templist;
	}
	
	public List<CourseVo> formatDateAndTeacher(List<Course> list){
		List<CourseVo> templist = new ArrayList<CourseVo>();
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
		Date date=new Date();
		for(int i=0;i<list.size();i++) {
			coursevo = new CourseVo();
			coursevo.setCourse(list.get(i));
			coursevo.setTime(sdf.format(list.get(i).getTime()));
			coursevo.setTeacher(list.get(i).getTeacher().getName());
			templist.add(coursevo);
		}
		return templist;
	}
	
	public CourseVo formatDateTime(Course arg) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		coursevo = new CourseVo();
		coursevo.setCourse(arg);
		coursevo.setTime(sdf.format(arg.getTime()));
		return coursevo;
	}
	
	
	
	public String[] getRecentWeek1() throws ParseException{
        String[] recentday = new String[7];
		Date d1 = new Date();
		Calendar cal = Calendar.getInstance();
	    cal.setTime(d1);
	    int w = -(cal.get(Calendar.DAY_OF_WEEK)-1);//w代表的是一周第几天 周日为0
        SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        SimpleDateFormat f1 =  new SimpleDateFormat("MM月dd号");     
        Date d2 = new Date();
        String now = f.format(d2);
		for(int j=0;j<7;j++) {
	        Date d3 = new Date(f.parse(now).getTime()+w*24*3600*1000);
	        String late = f1.format(d3);
	        w++;
	        recentday[j]=late;
		}
		return recentday;
	}
	public String[] getRecentWeek2() throws ParseException{
		String[] recentday = new String[7];
		Date d1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		int w = -(cal.get(Calendar.DAY_OF_WEEK)-1);//w代表的是一周第几天 周日为0
		SimpleDateFormat f =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		SimpleDateFormat f1 =  new SimpleDateFormat("MM-dd");     
		Date d2 = new Date();
		String now = f.format(d2);
		for(int j=0;j<7;j++) {
			Date d3 = new Date(f.parse(now).getTime()+w*24*3600*1000);
			String late = f1.format(d3);
			w++;
			recentday[j]=late;
		}
		return recentday;
	}
	
	
	
	
}