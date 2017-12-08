package cn.lxy.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cn.lxy.action.BasicAction;
import cn.lxy.po.Course;
import cn.lxy.po.Exam;
import cn.lxy.po.Student;
import cn.lxy.po.Teacher;
import cn.lxy.service.CourseServc;
import cn.lxy.service.ExamServc;
import cn.lxy.service.StudentServc;
import cn.lxy.service.TeacherServc;

public class AddPoAction extends BasicAction{
	
	private Student student;
	@Autowired
	private StudentServc studentServc;
	
	private Teacher teacher;
	@Autowired
	private TeacherServc teacherServc;
	@Autowired
	private CourseServc courseServc;
	
	private Exam exam;
	private Course course;
	@Autowired
	private ExamServc examServc;
	
	public String addStudent() {
		for(int i=0;i<60;i++) {
			student = new Student();
			student.setName("student"+i);
			student.setUserstatus(1);
			studentServc.save(student);
		}	
		return "success";
	}
	
	public String addTeacher() {
		for(int i=0;i<60;i++) {
			teacher = new Teacher();
			teacher.setName("teacher"+i);
			teacherServc.save(teacher);
		}
		return "success";
	}
	
	public String addExam() throws Exception {
		for(int i=0;i<60;i++) {
			teacher = teacherServc.find("1");
			exam = new Exam();
			exam.setName("高等数学:"+i);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			String time = sdf.format(d);
			Date d2 = sdf.parse(time);
			exam.setTime(d2);
			exam.setDescribes("普通高等院校高等数学");
			exam.setTeacher(teacher);
			examServc.save(exam);
		}		
		return "success";
	}
	
	public String addCourse() throws Exception {
		
		for(int i=0;i<60;i++) {
			teacher = teacherServc.find("1");
			course = new Course();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse("2017-12-05 23:12:12");
			course.setTime(date);
			course.setCoursetype(0);
			course.setName("课程->"+i);
			course.setTeacher(teacher);
			courseServc.save(course);
		}
		
		return "success";
	}
	
	
}
