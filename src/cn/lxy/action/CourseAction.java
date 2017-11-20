package cn.lxy.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Course;
import cn.lxy.po.Teacher;
import cn.lxy.service.CourseServc;

/**
 * <p>Title:CourseAction</p>
 * <p>Description: 课程实体控制器</p>
 * @author 李银龙
 *		2017年11月20日
 *		下午9:50:50
 */
public class CourseAction extends BasicAction implements ModelDriven<Course> {
	@Autowired
	private Course course;
	@Autowired
	private Teacher teacher;
	@Autowired
	private CourseServc servc;
	
	private List<Course> listCourse = new ArrayList<Course>();
	@Override
	public Course getModel() {
		return course;
	}

	//教师创建一个直播课程
	public String save() {
		teacher = (Teacher) this.getSesion().get("Teacher");
		course.setTeacher(teacher);
		servc.save(course);
		return "save";
	}
	//管理员查找所有课程
	public String findAll() {
		listCourse.clear();
		listCourse = servc.findAll("");
		return "findAll";
	}
	//教师查找属于自己的所有课程
	public String findByTeacherId() {
		teacher = (Teacher) this.getSesion().get("Teacher");
		listCourse.clear();
		listCourse.addAll(teacher.getSetCourse());
		return null;
	}
	//教师根据课程名称或科目查找自己的课程
	public String teacherFindByInfo() {
		String info = "";
		teacher = (Teacher) this.getSesion().get("Teacher");
		listCourse.clear();
		listCourse = servc.teacherFindByInfo(info, String.valueOf(teacher.getId()));
		return "teacherFindByInfo";
	}
	//根据课程名称或科目查找课程
	public String findByInfo() {
		String queryInfo = "";
		listCourse.clear();
		listCourse = servc.findByInfo(queryInfo);
		return "findByInfo";
	}
	
	
	
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}

	
}
