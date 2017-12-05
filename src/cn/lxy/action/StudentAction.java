package cn.lxy.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Student;
import cn.lxy.service.StudentServc;
import cn.lxy.utils.CountAllPage11;

/**
 * <p>Title:StudentAction</p>
 * <p>Description: 学生实体控制器</p>
 * @author 李银龙
 *		2017年11月20日
 *		下午9:52:40
 */
public class StudentAction extends BasicAction implements ModelDriven<Student> {
	private String resultinfo;
	private String enablePageNumber;
	private String disablePageNumber;
	private int userRole;
	
	private int[] pageDirection = new int[2];
	private int[] pageDirectionNumber = new int[2];
	@Autowired
	private CountAllPage11 countAllPage;
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
		userRole = 1;
		liststudent.clear();
		pages.clear();
		liststudent = servc.findAll("");
		int temp = countAllPage.getAllPage(liststudent.size());
		pageDirection = countAllPage.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage.getDirectionNumber(1, temp);
		this.enablePageNumber="1";
		this.getSesion().put("allEnableStudentPage",temp);
		this.getSesion().put("enableListStudent", liststudent);
		pages = countAllPage.getStartPages(temp);
		return "findAll";
	}
	//查找所有已禁用学生用户
	public String findAllDisabled() {
		userRole = 0;
		liststudent.clear();
		pages.clear();
		liststudent = servc.findAllDisabled("");
		int temp = countAllPage.getAllPage(liststudent.size());
		pageDirection = countAllPage.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage.getDirectionNumber(1, temp);
		this.enablePageNumber="1";
		this.getSesion().put("allDisabledStudentPage",temp);
		this.getSesion().put("disabledListStudent", liststudent);
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
	//根据页码查找未禁用学生页面的数据
	public String findEnableByPageNumber() {
		userRole = 1;
		int page = Integer.parseInt(enablePageNumber);
		int all = Integer.parseInt(this.getSesion().get("allEnableStudentPage").toString());
		pageDirection = countAllPage.getLeftAndRight(page,all);
		pageDirectionNumber = countAllPage.getDirectionNumber(page,all);
		tempstudent = (List<Student>) this.getSesion().get("enableListStudent");
		liststudent = tempstudent.subList((page-1)*11,countAllPage.getLastIndex(page,tempstudent.size()));
		pages.clear();
		pages = countAllPage.getPages(Integer.parseInt(enablePageNumber),Integer.parseInt(this.getSesion().get("allEnableStudentPage").toString()));
		return "findAll";
	}
	//根据页码查找已禁用学生页面的数据
	public String findDisabledByPageNumber() {
		userRole = 0;
		int page = Integer.parseInt(disablePageNumber);
		int all = Integer.parseInt(this.getSesion().get("allDisabledStudentPage").toString());
		pageDirection = countAllPage.getLeftAndRight(page,all);
		pageDirectionNumber = countAllPage.getDirectionNumber(page,all);
		tempstudent = (List<Student>) this.getSesion().get("disabledListStudent");
		liststudent = tempstudent.subList((page-1)*11,countAllPage.getLastIndex(page,tempstudent.size()));
		pages.clear();	
		pages = countAllPage.getPages(Integer.parseInt(disablePageNumber),Integer.parseInt(this.getSesion().get("allDisabledStudentPage").toString()));
		return "findAll";
	}
	//根据姓名查找学生,并将查询结果保存在值栈中
	public String findByName() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String name = request.getParameter("studentName");
		userRole = 0;
		liststudent.clear();
		liststudent = servc.findByName(name);
		this.getSesion().put("studentQueryInfo",name);
		return "findByName";
	}
	//根据查找记录显示查找过的学生
	public String showByResult() throws Exception {
		userRole = 0;
		liststudent.clear();
		liststudent = servc.findByName(this.getSesion().get("studentQueryInfo").toString());
		return "findByName";
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
	public int[] getPageDirection() {
		return pageDirection;
	}
	public void setPageDirection(int[] pageDirection) {
		this.pageDirection = pageDirection;
	}
	public int[] getPageDirectionNumber() {
		return pageDirectionNumber;
	}
	public void setPageDirectionNumber(int[] pageDirectionNumber) {
		this.pageDirectionNumber = pageDirectionNumber;
	}
	public String getDisablePageNumber() {
		return disablePageNumber;
	}
	public void setDisablePageNumber(String disablePageNumber) {
		this.disablePageNumber = disablePageNumber;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	
}
