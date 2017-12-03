package cn.lxy.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	public CourseVo formatDateTime(Course arg) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		coursevo = new CourseVo();
		coursevo.setCourse(arg);
		coursevo.setTime(sdf.format(arg.getTime()));
		return coursevo;
	}
	
}