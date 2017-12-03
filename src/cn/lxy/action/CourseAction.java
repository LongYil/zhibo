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

import cn.lxy.po.Course;
import cn.lxy.po.Student;
import cn.lxy.po.Teacher;
import cn.lxy.service.CourseServc;
import cn.lxy.utils.CountAllPage;
import cn.lxy.utils.DateUtils;
import cn.lxy.utils.FileUtils;
import cn.lxy.utils.StreamUtils;
import cn.lxy.vo.CourseVo;

/**
 * <p>Title:CourseAction</p>
 * <p>Description: 课程实体控制器</p>
 * @author 李银龙
 *		2017年11月20日
 *		下午9:50:50
 */
public class CourseAction extends BasicAction implements ModelDriven<Course> {
	@Autowired
	private Course course;
	@Autowired
	private CourseVo courseVo;
	@Autowired
	private Teacher teacher;
	@Autowired
	private CourseServc servc;
	@Autowired
	private FileUtils fileUtils;
	@Autowired
	private DateUtils dateUtils;
	@Autowired
	private CountAllPage countAllPage;
	
    private List<File> coursefile ;  
    private List<String> coursefileFileName ;  
    private List<String> coursefileContentType ;
    private String pageNumber;
	
	private int[] pageDirection = new int[2];
	private int[] pageDirectionNumber = new int[2];

	private List<Integer> pages = new ArrayList<Integer>();
	private List<CourseVo> listCourse = new ArrayList<CourseVo>();
	private List<CourseVo> tempListCourse = new ArrayList<CourseVo>();
	
	private String courseName;
	
	private String resultinfo;
	@Override
	public Course getModel() {
		return course;
	}
	
	//教师创建一个直播课程
	public String save() throws ParseException {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String coursePic = request.getParameter("coursePic");
		String tempTime = request.getParameter("time");
		String[] infos = coursePic.split(",");
		String realpath = ServletActionContext.getServletContext().getRealPath("/sourcefile/courseimage");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(tempTime);
		course.setTime(date);
		course.setFace(fileUtils.generateCourseImage(infos[1], realpath,coursefileFileName.get(0)));
		teacher = (Teacher) this.getSesion().get("Teacher");
		course.setTeacher(teacher);
		course.setStreamid(StreamUtils.getStreamId(teacher.getRoomid(),tempTime));
		course.setCoursetype(0);
		servc.save(course);
		return "save";
	}
	//管理员查找所有直播课程
	public String findAll() {
		listCourse.clear();
		pages.clear();
		listCourse = dateUtils.formatDateTime(servc.findAll(""));
		int temp = countAllPage.getAllPage(listCourse.size());
		pageDirection = countAllPage.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage.getDirectionNumber(1, temp);
		this.getSesion().put("allLiveCoursePage",temp);
		this.getSesion().put("liveCourseList", listCourse);
		pages = countAllPage.getStartPages(temp);	
		return "findAll";
	}
	//教师查找属于自己的所有直播课程
	public String findByTeacherId() {
		teacher = (Teacher) this.getSesion().get("Teacher");
		listCourse.clear();
		pages.clear();
		listCourse = dateUtils.formatDateTime(servc.findByTeacherId(String.valueOf(teacher.getId())));
		
		int temp = countAllPage.getAllPage(listCourse.size());
		pageDirection = countAllPage.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage.getDirectionNumber(1, temp);
		this.getSesion().put("allLiveCoursePage",temp);
		this.getSesion().put("liveCourseList", listCourse);
		pages = countAllPage.getStartPages(temp);
		
		return "findByTeacherId";
	}
	//教师根据页码查找所有直播课程
	public String findByPageNumber() {
		tempListCourse.clear();
		listCourse.clear();
		pages.clear();
		
		int page = Integer.parseInt(pageNumber);
		int all = Integer.parseInt(this.getSesion().get("allLiveCoursePage").toString());
		pageDirection = countAllPage.getLeftAndRight(page,all);
		pageDirectionNumber = countAllPage.getDirectionNumber(page,all);
		tempListCourse = (List<CourseVo>) this.getSesion().get("liveCourseList");
		listCourse = tempListCourse.subList((page-1)*11,countAllPage.getLastIndex(page,tempListCourse.size()));
		pages.clear();	
		pages = countAllPage.getPages(Integer.parseInt(pageNumber),Integer.parseInt(this.getSesion().get("allLiveCoursePage").toString()));
		return "findByPageNumber";
	}
	//教师根据课程名称或科目查找自己的直播课程
	public String teacherFindByInfo() {
		teacher = (Teacher) this.getSesion().get("Teacher");
		listCourse.clear();
		listCourse = dateUtils.formatDateTime(servc.teacherFindByInfo(courseName, String.valueOf(teacher.getId())));
		return "teacherFindByInfo";
	}
	//根据课程名称或科目查找课程
	public String findByInfo() {
		String queryInfo = "";
		listCourse.clear();
		listCourse = dateUtils.formatDateTime(servc.findByInfo(queryInfo));
		return "findByInfo";
	}
	//删除课程
	public String delete() throws Exception {
		this.resultinfo = "0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		String courseId = request.getParameter("info");		
		course = servc.findByCourseId(courseId);
		servc.delete(course);
		this.resultinfo = "1";
		return "delete";
	}
	//根据课程id查找课程
	public String preUpdate() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String courseId = request.getParameter("courseId");
		course = servc.findByCourseId(courseId);
		courseVo = dateUtils.formatDateTime(course);
		this.getSesion().put("updateCourseId", courseId);
		return "preUpdate";
	}
	public String update() {
		course.setId(Integer.parseInt(this.getSesion().get("updateCourseId").toString()));
		servc.update(course);
		return "update";		
	}
	//主页
	public String findRecentCource() {
		
		
		
		return "";
	}
	
	

	public String findByCourseId() {
		
		return null;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public FileUtils getFileUtils() {
		return fileUtils;
	}

	public void setFileUtils(FileUtils fileUtils) {
		this.fileUtils = fileUtils;
	}

	public DateUtils getDateUtils() {
		return dateUtils;
	}

	public void setDateUtils(DateUtils dateUtils) {
		this.dateUtils = dateUtils;
	}

	public List<File> getCoursefile() {
		return coursefile;
	}

	public void setCoursefile(List<File> coursefile) {
		this.coursefile = coursefile;
	}

	public List<String> getCoursefileFileName() {
		return coursefileFileName;
	}

	public void setCoursefileFileName(List<String> coursefileFileName) {
		this.coursefileFileName = coursefileFileName;
	}

	public List<String> getCoursefileContentType() {
		return coursefileContentType;
	}

	public void setCoursefileContentType(List<String> coursefileContentType) {
		this.coursefileContentType = coursefileContentType;
	}

	public List<CourseVo> getListCourse() {
		return listCourse;
	}

	public void setListCourse(List<CourseVo> listCourse) {
		this.listCourse = listCourse;
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

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getResultinfo() {
		return resultinfo;
	}

	public void setResultinfo(String resultinfo) {
		this.resultinfo = resultinfo;
	}

	public CourseVo getCourseVo() {
		return courseVo;
	}

	public void setCourseVo(CourseVo courseVo) {
		this.courseVo = courseVo;
	}




	
}
