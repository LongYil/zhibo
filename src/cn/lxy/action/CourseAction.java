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
 * <p>Description: �γ�ʵ�������</p>
 * @author ������
 *		2017��11��20��
 *		����9:50:50
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

	//��ʦ����һ��ֱ���γ�
	public String save() {
		teacher = (Teacher) this.getSesion().get("Teacher");
		course.setTeacher(teacher);
		servc.save(course);
		return "save";
	}
	//����Ա�������пγ�
	public String findAll() {
		listCourse.clear();
		listCourse = servc.findAll("");
		return "findAll";
	}
	//��ʦ���������Լ������пγ�
	public String findByTeacherId() {
		teacher = (Teacher) this.getSesion().get("Teacher");
		listCourse.clear();
		listCourse.addAll(teacher.getSetCourse());
		return null;
	}
	//��ʦ���ݿγ����ƻ��Ŀ�����Լ��Ŀγ�
	public String teacherFindByInfo() {
		String info = "";
		teacher = (Teacher) this.getSesion().get("Teacher");
		listCourse.clear();
		listCourse = servc.teacherFindByInfo(info, String.valueOf(teacher.getId()));
		return "teacherFindByInfo";
	}
	//���ݿγ����ƻ��Ŀ���ҿγ�
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
