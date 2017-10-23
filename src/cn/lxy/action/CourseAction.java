package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Course;
import cn.lxy.service.CourseServc;

public class CourseAction extends BasicAction<CourseServc> implements ModelDriven<Course> {
	@Autowired
	private Course course;
	
	@Override
	public Course getModel() {
		return course;
	}

	
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	
}
