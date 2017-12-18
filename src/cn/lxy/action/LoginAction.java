package cn.lxy.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.lxy.po.Student;
import cn.lxy.po.Teacher;
import cn.lxy.service.StudentServc;
import cn.lxy.service.TeacherServc;

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
	private Student student;

	//�û���¼
	public String login() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String url =request.getRequestURI().toString();
		if(usertype==0) {//�û����ͣ�ѧ��
			student = studentServc.login(username, password);
			if(student.getTel()!=null&&student.getTel()!="") {
				this.getSesion().put("Student", student);
				this.getSesion().put("studentUserStatus",1);
				if(student.getBirth()!=null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String[] tempBirth = sdf.format(student.getBirth()).split("-");					
					String[] birth = {tempBirth[0],tempBirth[1],tempBirth[2]};
					this.getSesion().put("birth", birth);
			        this.getSesion().put("tab1", "");
			        this.getSesion().put("tempPicPath",student.getHead());
			        this.getSesion().put("tab3", "display:none");
				}
				return "student";
			}else {
				return "";
			}
		}else if(usertype==1){//�û����ͣ���ʦ
			teacher = teacherServc.login(username, password);
			this.getSesion().put("Teacher", teacher);
			return "teacher";
		}else {
			return "";
		}

	}
	//ѧ���û�ע���û�
	public String logout() {
		this.getSesion().clear();
		return "student";
	}
	//��������
	public String personalCenter() {
		
		
		
		return "personalCenter";
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
	

}
