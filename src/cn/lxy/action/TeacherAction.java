package cn.lxy.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Student;
import cn.lxy.po.Teacher;
import cn.lxy.service.StudentServc;
import cn.lxy.service.TeacherServc;
import cn.lxy.utils.CountAllPage11;
import cn.lxy.utils.ServerInfo;

/**
 * <p>Title:TeacherAction</p>
 * <p>Description: 教师实体控制器</p>
 * @author 李银龙
 *		2017年11月20日
 *		下午9:52:54
 */
public class TeacherAction extends BasicAction implements ModelDriven<Teacher> {
	@Autowired
	private Teacher teacher;
	@Autowired
	private TeacherServc servc;
	@Autowired
	private Student student;
	@Autowired
	private StudentServc studentServc;
	@Autowired
	private CountAllPage11 countAllPage;
	private String teacherTempId;
	private String resultinfo;
	private String enablePageNumber;
	private String username;
    private File file1 ; //具体上传文件的 引用 , 指向临时目录中的临时文件  
    private String file1FileName ;  // 上传文件的名字 ,FileName 固定的写法  
    private String file1ContentType ; //上传文件的类型， ContentType 固定的写法
	private int[] pageDirection = new int[2];
	private int[] pageDirectionNumber = new int[2];
	private List<Teacher> listteacher = new ArrayList<Teacher>();
	private List<Integer> pages = new ArrayList<Integer>();
	private List<Teacher> tempteacher = new ArrayList<Teacher>();
	@Override
	public Teacher getModel() {
		return teacher;
	}
	//用户执行添加教师操作
	public String addTeacher() {
		return "addTeacher";
	}
	//添加教师
	public String saveInfo() throws UnsupportedEncodingException {
		this.resultinfo="0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		String info = request.getParameter("info");
		info = URLDecoder.decode(info,"UTF-8");
		String[] infos = info.split("-");
		if(infos[0]!=null&&!infos[0].equals("")) {
			teacher.setId(Integer.parseInt(infos[0]));
		}else {
			;
		}
		teacher.setUsername(infos[1]);
		teacher.setName(infos[2]);
		teacher.setTel(infos[3]);
		teacher.setPassword(infos[4]);
		teacher.setHead("http://"+ServerInfo.SERVER_IP+"/CollegeLive/Image/teacher.png");
		teacher.setRoomid(new SimpleDateFormat("DDMMYYYYhhmmss").format(new Date()));
		servc.save(teacher);
		student.setUsername(teacher.getUsername());
		student.setName(teacher.getName());
		student.setTel(teacher.getTel());
		student.setPassword(teacher.getPassword());
		student.setHead(teacher.getHead());
		studentServc.save(student);
		this.resultinfo="1";
		return "saveInfo";
	}
	//教师查询个人资料
	public String selfInfo() {
		teacher = (Teacher) this.getSesion().get("Teacher");
		return "selfInfo";
	}
	//查找所有教师
	public String findAll() {
		this.getSesion().remove("queryTeacherName");
		listteacher.clear();
		pages.clear();
		listteacher = servc.findAll("");
		int temp = countAllPage.getAllPage(listteacher.size());
		pageDirection = countAllPage.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage.getDirectionNumber(1, temp);
		this.enablePageNumber="1";
		this.getSesion().put("allTeacherPage",temp);
		this.getSesion().put("enableListTeacher", listteacher);
		this.getSesion().put("enablePageNumber", "1");
		pages = countAllPage.getStartPages(temp);
		return "findAll";
	}
	//根据页码查找相应页面的数据
	public String findEnableByPageNumber() {		
		int page = Integer.parseInt(enablePageNumber);
		int all = Integer.parseInt(this.getSesion().get("allTeacherPage").toString());
		pageDirection = countAllPage.getLeftAndRight(page,all);
		pageDirectionNumber = countAllPage.getDirectionNumber(page,all);
		tempteacher = (List<Teacher>) this.getSesion().get("enableListTeacher");
		listteacher = tempteacher.subList((page-1)*11,countAllPage.getLastIndex(page,tempteacher.size()));
		pages.clear();
		pages = countAllPage.getPages(page,Integer.parseInt(this.getSesion().get("allTeacherPage").toString()));
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
	//保存头像
	public void updateIcon() throws IOException {
		
	}
	//根据教师姓名进行查询，支持模糊查询
	public String findByName() {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String info = request.getParameter("teacherName");
		this.getSesion().put("queryTeacherName", info);
		listteacher.clear();
		listteacher = servc.findByName(info);
		return "findByName";
	}
	//删除教师后根据保存的信息重新查询
	public String requery() throws Exception {
		this.resultinfo="0";
		String info = this.getSesion().get("queryTeacherName").toString();
		listteacher.clear();
		listteacher = servc.findByName(info);
		this.resultinfo="1";
		return "findByName";
	}	
	//用户点击填写教师信息页面的返回操作
	public String backAndQuery() {
		if(this.getSesion().get("queryTeacherName")!=null) {
			return "back_requery";
		}else {
			return "back_findAll";
		}
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public File getFile1() {
		return file1;
	}
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public String getFile1FileName() {
		return file1FileName;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public String getFile1ContentType() {
		return file1ContentType;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}	
}
