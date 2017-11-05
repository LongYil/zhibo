package cn.lxy.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Student;
import cn.lxy.service.StudentServc;
import cn.lxy.utils.CountAllPage;

public class StudentAction extends BasicAction implements ModelDriven<Student> {
	
	private String resultinfo;
	private String enablePageNumber;
	
	@Autowired
	private CountAllPage countAllPage;
	@Autowired
	private Student student ;
	@Autowired
	private StudentServc servc;
	
	private List<Student> liststudent = new ArrayList<Student>();
	private List<Integer> pages = new ArrayList<Integer>();
	private List<Student> tempstudent = new ArrayList<Student>();
	
	@Override
	public Student getModel() {
		return student;
	}
	//学生用户注册新用户
	public String add() {
		student.setUserstatus(1);
		servc.save(student);
		return "add";
	}
	//查找所有未禁用学生用户
	public String findAllEnable() {
		liststudent.clear();
		pages.clear();
		liststudent = servc.findAll("");
		int temp = countAllPage.getAllPage(liststudent.size());
		this.getSesion().put("allEnableStudentPage",temp);
		this.getSesion().put("enableListStudent", liststudent);
		pages = countAllPage.getStartPages(temp);
		return "findAll";
	}
	//查找所有已禁用学生用户
	public String findAllDisabled() {
		liststudent.clear();
		liststudent = servc.findAllDisabled("");
		int temp = countAllPage.getAllPage(liststudent.size());
		this.getSesion().put("allDisabledStudentPage",temp);
		pages = countAllPage.getStartPages(temp);
		return "findAll";
	}
	//禁用学生用户
	public String forbidden() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String userid = request.getParameter("info");
		this.resultinfo = servc.forbidden(userid);
		return "ajaxresult1";
	}
	//启用学生用户
	public String start() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String userid = request.getParameter("info");
		this.resultinfo = servc.start(userid);
		return "ajaxresult1";
	}
	//根据页码查找相应页面的数据
	public String findEnableByPageNumber() {
		int page = Integer.parseInt(enablePageNumber);
		tempstudent = (List<Student>) this.getSesion().get("enableListStudent");
		liststudent = tempstudent.subList((page-1)*11,countAllPage.getLastIndex(page,tempstudent.size()));
		System.out.println(liststudent.size());
		pages.clear();	
		pages = countAllPage.getPages(Integer.parseInt(enablePageNumber),Integer.parseInt(this.getSesion().get("allEnableStudentPage").toString()));
		return "findAll";
	}
	
	
	
	
	
	
	
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Student> getListstudent() {
		return liststudent;
	}
	public void setListstudent(List<Student> liststudent) {
		this.liststudent = liststudent;
	}
	public String getResultinfo() {
		return resultinfo;
	}
	public void setResultinfo(String resultinfo) {
		this.resultinfo = resultinfo;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	public String getEnablePageNumber() {
		return enablePageNumber;
	}
	public void setEnablePageNumber(String enablePageNumber) {
		this.enablePageNumber = enablePageNumber;
	}
	
}
