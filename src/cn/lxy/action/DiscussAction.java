package cn.lxy.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Course;
import cn.lxy.po.Discuss;
import cn.lxy.po.Student;
import cn.lxy.service.CourseServc;
import cn.lxy.service.DiscussServc;
import cn.lxy.utils.GetDateAndTime;

/**
 * <p>Title:DiscussAction</p>
 * <p>Description: 讨论实体控制器</p>
 * @author 李银龙
 *		2017年11月20日
 *		下午9:51:02
 */
public class DiscussAction extends BasicAction implements ModelDriven<Discuss> {
	@Autowired
	private Discuss discuss;
	@Autowired
	private DiscussServc servc;
	@Autowired
	private Student student;
	@Autowired
	private Course course;
	@Autowired
	private CourseServc courseServc;
	@Autowired
	private GetDateAndTime getDateAndTime;
	private List<Discuss> listDiscuss = new ArrayList<Discuss>();
	private String resultinfo;
	@Override
	public Discuss getModel() {
		return discuss;
	}
	//保存讨论
	public String save() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String discussContent = request.getParameter("info");
		discussContent = URLDecoder.decode(discussContent,"UTF-8");
		course = (Course) this.getSesion().get("liveCourse");
		student = (Student) this.getSesion().get("Student");
		discuss.setContent(discussContent);
		discuss.setStudent(student);
		discuss.setCourse(course);
		discuss.setTime(getDateAndTime.getNowTime());
		servc.save(discuss);
		return null;
	}
	//根据课程id查找该课程的所有讨论
	public String findByCourseId() {
		String id = null;
		listDiscuss.clear();
		listDiscuss = servc.findByCourseId(id);
		return null;
	}
    public Discuss getDiscuss() {
		return discuss;
	}
	public void setDiscuss(Discuss discuss) {
		this.discuss = discuss;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getResultinfo() {
		return resultinfo;
	}
	public void setResultinfo(String resultinfo) {
		this.resultinfo = resultinfo;
	}
	public List<Discuss> getListDiscuss() {
		return listDiscuss;
	}
	public void setListDiscuss(List<Discuss> listDiscuss) {
		this.listDiscuss = listDiscuss;
	}
}
