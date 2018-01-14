package cn.lxy.action;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lxy.po.Carousel;
import cn.lxy.po.Manager;
import cn.lxy.po.Student;
import cn.lxy.po.Teacher;
import cn.lxy.service.CarouselServc;
import cn.lxy.service.ManagerServc;
import cn.lxy.service.StudentServc;
import cn.lxy.service.TeacherServc;
import cn.lxy.utils.ServerInfo;

/**
 * <p>Title:LoginAction</p>
 * <p>Description: ��¼ʵ�������</p>
 * @author ������
 *		2017��11��20��
 *		����9:52:04
 */
public class LoginAction extends BasicAction {
	private String username;
	private String password;
	private int usertype;
	@Autowired
	private TeacherServc teacherServc;
	@Autowired
	private Teacher teacher;
	@Autowired
	private StudentServc studentServc;
	@Autowired
	private Manager manager;
	@Autowired
	private ManagerServc managerServc;
	private Student student;
	private String resultinfo;
	//�û���¼
	public String login() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		username = request.getParameter("username");
		password = request.getParameter("password");
		usertype = Integer.parseInt(request.getParameter("usertype"));
		this.getSesion().put("ip", ServerInfo.SERVER_IP);
		if(usertype == 0) {
			//�û����ͣ�ѧ��
			student = studentServc.login(username, password);
			if(student.getTel()!=null&&student.getTel()!="") {
				this.getSesion().put("Student", student);
				this.getSesion().put("userName", student.getName());
				this.getSesion().put("StudentId", student.getId());
				this.getSesion().put("userStaticStatus",1);
				this.getSesion().put("userStatus","1");
				this.getSesion().put("userType","0");
				this.getSesion().put("tempPicPath",student.getHead());
				if(student.getBirth()!=null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String[] tempBirth = sdf.format(student.getBirth()).split("-");					
					String[] birth = {tempBirth[0],tempBirth[1],tempBirth[2]};
					this.getSesion().put("birth", birth);
				}
				this.getSesion().put("tab1", "");
				this.getSesion().put("tab3", "display:none");
				String temp ;
				try {
					temp = this.getSesion().get("loginMethod").toString();
				}catch(Exception e) {
					temp = "";
				}
				if(temp.equals("watch1")) {
					return "watchTemp1";
				}else if(temp.equals("watch2")) {
					return "watchTemp2";
				}else if(temp.equals("analyseExam")) {
					return "analyseExamTemp";
				}else {
					return "student";
				}
			}else {
				return "student";
			}
		}else if(usertype == 1){
			//�û����ͣ���ʦ
			teacher = teacherServc.login(username, password);
			student = studentServc.login(username, password);
			this.getSesion().put("userType","1");
			this.getSesion().put("Teacher", teacher);
			this.getSesion().put("userName", teacher.getName());
			this.getSesion().put("userStaticStatus",1);
			this.getSesion().put("userStatus","1");
	        this.getSesion().put("tempPicPath",teacher.getHead());
			this.getSesion().put("Student", student);
			this.getSesion().put("StudentId", student.getId());
			return "student";
		}else {
			//�û����ͣ���������Ա
			this.getSesion().put("userType","2");
			manager = managerServc.login(username, password);
			student = studentServc.login(username, password);
			this.getSesion().put("Manager", manager);
			this.getSesion().put("userName", manager.getName());
			this.getSesion().put("userStaticStatus",1);
			this.getSesion().put("userStatus","1");
	        this.getSesion().put("tempPicPath",manager.getHead());
			this.getSesion().put("Student", student);
			this.getSesion().put("StudentId", student.getId());
			return "student";
		}
	}
	//ajax��֤�û���¼
	public String preLogin() throws Exception {	
		HttpServletRequest request =  ServletActionContext.getRequest();
		String info = request.getParameter("info");
		info = URLDecoder.decode(info,"UTF-8");
		this.resultinfo = "0";
		String[] infos = info.split("-");//�û���Ϣ  �û�����-�û���-�û����� �û����ͣ�0 ѧ�� 1 ��ʦ 2 ����Ա
		this.getSesion().put("username", infos[1]);
		this.getSesion().put("password", infos[2]);
		this.getSesion().put("usertype", infos[0]);
		if(infos[0].equals("0")) {
			//ѧ���û�
			student = studentServc.login(infos[1], infos[2]);
			if(student.getPassword() != null && student.getPassword() != "") {
			  //ѧ������
			  this.resultinfo = "1";
			  return "preLogin";
			}else {
		      this.resultinfo = "0";
		      return "preLogin";
			}
		}else if(infos[0].equals("1")) {
			//��ʦ�û�
			teacher = teacherServc.login(infos[1], infos[2]);
			if(teacher.getPassword() != null && teacher.getPassword() != "") {
				this.resultinfo = "1";
				return "preLogin";
			}else {
				 this.resultinfo = "0";
				return "preLogin";
			}
		}else {
			//����Ա�û�
			manager = managerServc.login(infos[1], infos[2]);
			if(manager.getPassword() != null && manager.getPassword() != "") {

				this.resultinfo = "1";
				return "preLogin";
			}else {
				 this.resultinfo = "0";
				return "preLogin";
			}			
		}
	}
	//ѧ���û�ע���û�
	public String logout() {
		this.getSesion().clear();
		return "student";
	}
	//��������
	public String personalCenter() {
		String tempUserType = this.getSesion().get("userType").toString();
		if(tempUserType.equals("0")) {
			//ѧ���û�	
			return "studentPersonalCenter";
		}else if(tempUserType.equals("1")) {
			//��ʦ�û�	
			return "teacherPersonalCenter";
		}else {
			//����Ա�û�	
			return "administratorPersonalCenter";
		}
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public String getResultinfo() {
		return resultinfo;
	}
	public void setResultinfo(String resultinfo) {
		this.resultinfo = resultinfo;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
