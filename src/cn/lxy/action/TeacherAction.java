package cn.lxy.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Teacher;
import cn.lxy.service.TeacherServc;
import cn.lxy.utils.CountAllPage;

public class TeacherAction extends BasicAction implements ModelDriven<Teacher> {
	@Autowired
	private Teacher teacher;
	@Autowired
	private TeacherServc servc;
	@Autowired
	private CountAllPage countAllPage;
	
	private String teacherTempId;
	private String resultinfo;
	private String enablePageNumber;
	
	private int[] pageDirection = new int[2];
	private int[] pageDirectionNumber = new int[2];
	
	private List<Teacher> listteacher = new ArrayList<Teacher>();
	private List<Integer> pages = new ArrayList<Integer>();
	private List<Teacher> tempteacher = new ArrayList<Teacher>();	

	@Override
	public Teacher getModel() {
		return teacher;
	}
	
	//添加教师
	public String add() {
		servc.save(teacher);
		listteacher.clear();
		pages.clear();
		listteacher = servc.findAll("");
		int temp = countAllPage.getAllPage(listteacher.size());
		pageDirection = countAllPage.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage.getDirectionNumber(1, temp);
		this.enablePageNumber="1";
		this.getSesion().put("allTeacherPage",temp);
		this.getSesion().put("enableListTeacher", listteacher);
		pages = countAllPage.getStartPages(temp);
		return "findAll";
	}
	//教师查询个人资料
	public String selfInfo() {
		teacher = (Teacher) this.getSesion().get("Teacher");
		System.out.println("查找教师信息");
		return "selfInfo";
	}
	//查找所有教师
	public String findAll() {
		listteacher.clear();
		pages.clear();
		listteacher = servc.findAll("");
		int temp = countAllPage.getAllPage(listteacher.size());
		pageDirection = countAllPage.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage.getDirectionNumber(1, temp);
		this.enablePageNumber="1";
		this.getSesion().put("allTeacherPage",temp);
		this.getSesion().put("enableListTeacher", listteacher);
		pages = countAllPage.getStartPages(temp);
		return "findAll";
	}
	//根据页码查找相应页面的数据
	public String findEnableByPageNumber() {
		int page = Integer.parseInt(enablePageNumber);
		int all = Integer.parseInt(this.getSesion().get("allTeacherPage").toString());
		pageDirection = countAllPage.getLeftAndRight(page,all);
		pageDirectionNumber = countAllPage.getDirectionNumber(page,all);
		System.out.println(pageDirectionNumber[0]+"*"+pageDirectionNumber[1]);
		tempteacher = (List<Teacher>) this.getSesion().get("enableListTeacher");
		listteacher = tempteacher.subList((page-1)*11,countAllPage.getLastIndex(page,tempteacher.size()));
		pages.clear();	
		pages = countAllPage.getPages(Integer.parseInt(enablePageNumber),Integer.parseInt(this.getSesion().get("allTeacherPage").toString()));
		return "findAll";
	}	
	//删除指定教师用户
	public String delete() throws Exception {
		this.resultinfo="0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		String teacherId = request.getParameter("info");
		teacher = servc.find(teacherId);
		servc.delete(teacher);
		this.resultinfo="1";
		return "delete";
	}
	//查询教师信息
	public String preUpdate() throws Exception {		
		teacher = servc.find(teacherTempId);
		return "preUpdate";
	}
	//更新教师密码
	public String updatePassword() throws UnsupportedEncodingException {
		this.resultinfo="0";
		teacher = (Teacher) this.getSesion().get("Teacher");
		HttpServletRequest request =  ServletActionContext.getRequest();
		String info = request.getParameter("info");
		String[] infos = info.split("-");
		System.out.println(infos[0]+"*"+infos[1]);
		if(infos[0].equals(teacher.getPassword())) {
			teacher.setPassword(infos[1]);
			servc.save(teacher);
			this.resultinfo="1";
			return "updatePassword";
		}else {
			return "updatePassword";
		}

	}
	//更新教师基本信息
	public String updateInfo() throws UnsupportedEncodingException {
		this.resultinfo="0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		teacher = (Teacher) this.getSesion().get("Teacher");
		String infos = request.getParameter("info");
		infos = URLDecoder.decode(infos,"UTF-8");
		System.out.println(infos);
		String[] info = infos.split("-");
		teacher.setName(info[0]);
		teacher.setTel(info[1]);
	    teacher.setSex(Integer.parseInt(info[2]));
		teacher.setSchool(info[3]);
		teacher.setSubject(info[4]);
		teacher.setTeacthage(Float.parseFloat(info[5]));
	    teacher.setEmail(info[6]);
	    servc.save(teacher);
		this.resultinfo="1";
		return "updateInfo";
	}
	
	
	
	
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Teacher> getListteacher() {
		return listteacher;
	}
	public void setListteacher(List<Teacher> listteacher) {
		this.listteacher = listteacher;
	}
	public String getResultinfo() {
		return resultinfo;
	}
	public void setResultinfo(String resultinfo1) {
		this.resultinfo= resultinfo1;
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
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	public List<Teacher> getTempteacher() {
		return tempteacher;
	}
	public void setTempteacher(List<Teacher> tempteacher) {
		this.tempteacher = tempteacher;
	}

	public String getTeacherTempId() {
		return teacherTempId;
	}

	public void setTeacherTempId(String teacherTempId) {
		this.teacherTempId = teacherTempId;
	}
	
}
