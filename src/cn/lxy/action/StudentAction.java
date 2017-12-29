package cn.lxy.action;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Student;
import cn.lxy.service.StudentServc;
import cn.lxy.utils.CountAllPage11;
import cn.lxy.utils.FileUtils;
import cn.lxy.utils.ServerInfo;
import cn.lxy.utils.VerificationCodeUtils;

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
	@Autowired
	private FileUtils fileUtils;
	@Autowired
	private VerificationCodeUtils verificationCodeUtils;
	
	private List<Student> liststudent = new ArrayList<Student>();
	private List<Integer> pages = new ArrayList<Integer>();
	private List<Student> tempstudent = new ArrayList<Student>();

    private List<File> picfile;
    private List<String> picfileFileName ;  
    private List<String> picfileContentType ;
    
	@Override
	public Student getModel() {
		return student;
	}
	//学生用户注册新用户
	public String add() {
		student.setUserstatus(1);
		student.setHead("http://"+ServerInfo.SERVER_IP+":8080/CollegeLive/Image/temphead.png");
		servc.save(student);
		this.getSesion().put("Student", student);
		this.getSesion().put("StudentId", student.getId());
		this.getSesion().put("studentUserStatus",1);
		if(student.getBirth()!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String[] tempBirth = sdf.format(student.getBirth()).split("-");					
			String[] birth = {tempBirth[0],tempBirth[1],tempBirth[2]};
			this.getSesion().put("birth", birth);
		}
		this.getSesion().put("tempPicPath",student.getHead());
        this.getSesion().put("tab1", "");
        this.getSesion().put("tab3", "display:none");
		return "student";
	}
	
	public String updatePassword() {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String[] passwordInfo = request.getParameter("info").split("-");		
		student = (Student) this.getSesion().get("Student");
		if(passwordInfo[0].equals(student.getPassword())){
			student.setPassword(passwordInfo[1]);
			servc.save(student);
			this.resultinfo = "1";
		}else {
			this.resultinfo = "0";
		}
		return "updatePassword";
	}
	//更新学生用户的基本信息
	public String updateBasicInfo() throws ParseException {
		student = (Student) this.getSesion().get("Student");
		HttpServletRequest request =  ServletActionContext.getRequest();
		String year = request.getParameter("selYear");
		String month = request.getParameter("selMonth");
		String day = request.getParameter("selDay");
		String birth = year + "-" + month + "-" + day;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse(birth);
		student.setUsername(request.getParameter("username").toString());
		student.setName(request.getParameter("name").toString());
		student.setDepartment(request.getParameter("department").toString());
		student.setClassandgrade(request.getParameter("classandgrade").toString());
		student.setSelfintroduce(request.getParameter("selfintroduce").toString());
		student.setBirth(d);
		servc.save(student);
		this.getSesion().put("Student",student);
		return "updateBasicInfo";
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
	//校验用户手机是否已存在
	public String checkAccount() {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String tel = request.getParameter("info");		
		this.resultinfo = String.valueOf(servc.checkAccount(tel));
		return "checkAccount";
	}
	//获取验证码
	public String getVerificationCode() {
		String temp = verificationCodeUtils.getCode();
		this.getSesion().put("VerificationCode", temp);
		this.resultinfo = temp;
		return "getVerificationCode";
	}
	//校验验证码
	public String checkVerificationCode() {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String info = request.getParameter("info").toLowerCase();		
		String[] temp1 = (this.getSesion().get("VerificationCode").toString().toLowerCase()).split(",");
		String temp = temp1[0] + temp1[1] + temp1[2] + temp1[3];
		if(info.equals(temp)) {
			this.resultinfo = "1";
		}else {
			this.resultinfo = "0";
		}
		return "checkVerificationCode";
	}
	//学生上传头像文件预览
	public String previewStudentIcon() throws Exception {
        String realpath = ServletActionContext.getServletContext().getRealPath("/sourcefile/studenticon"); 
        String picPath = fileUtils.saveIcon(picfile.get(0), realpath,picfileFileName.get(0));
        this.getSesion().put("tempPicPath", picPath);
        this.getSesion().put("tab1","display:none");
        this.getSesion().put("tab3","");
		return "previewStudentIcon";
	}
	//保存头像文件
	public String saveStudentIcon() {
		student = (Student) this.getSesion().get("Student");
		student.setHead(this.getSesion().get("tempPicPath").toString());
		servc.save(student);
        this.getSesion().put("tab1","");
        this.getSesion().put("tab3","display:none");
		return "saveStudentIcon";
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
	public List<File> getPicfile() {
		return picfile;
	}
	public void setPicfile(List<File> picfile) {
		this.picfile = picfile;
	}
	public List<String> getPicfileFileName() {
		return picfileFileName;
	}
	public void setPicfileFileName(List<String> picfileFileName) {
		this.picfileFileName = picfileFileName;
	}
	public List<String> getPicfileContentType() {
		return picfileContentType;
	}
	public void setPicfileContentType(List<String> picfileContentType) {
		this.picfileContentType = picfileContentType;
	}
	
}
