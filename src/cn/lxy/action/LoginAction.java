package cn.lxy.action;

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

	
	public String login() throws Exception {
		System.out.println(username+"*"+password+"*"+usertype);
		if(usertype==0) {//�û����ͣ�ѧ��
			student = studentServc.login(username, password);
			this.getSesion().put("Student", student);
		}else if(usertype==1){//�û����ͣ���ʦ
			teacher = teacherServc.login(username, password);
			this.getSesion().put("Teacher", teacher);
		}else {
			;
		}
		return "success";
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