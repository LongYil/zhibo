package cn.lxy.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Carousel;
import cn.lxy.po.Course;
import cn.lxy.po.Discuss;
import cn.lxy.po.Note;
import cn.lxy.po.Student;
import cn.lxy.po.Teacher;
import cn.lxy.service.CarouselServc;
import cn.lxy.service.CourseServc;
import cn.lxy.service.DiscussServc;
import cn.lxy.service.NoteServc;
import cn.lxy.service.StudentServc;
import cn.lxy.service.TeacherServc;
import cn.lxy.utils.CountAllPage11;
import cn.lxy.utils.CountAllPage6;
import cn.lxy.utils.DateUtils;
import cn.lxy.utils.FileUtils;
import cn.lxy.utils.ServerInfo;
import cn.lxy.utils.StreamUtils;
import cn.lxy.vo.CourseVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	private Course flagCourse;
	@Autowired
	private CourseVo courseVo;
	@Autowired
	private Student student;
	@Autowired
	private StudentServc studentServc;
	@Autowired
	private Teacher teacher;
	@Autowired
	private TeacherServc teacherServc;
	@Autowired
	private CourseServc servc;
	@Autowired
	private FileUtils fileUtils;
	@Autowired
	private DateUtils dateUtils;
	@Autowired
	private CountAllPage11 countAllPage11;
	@Autowired
	private CountAllPage6 countAllPage6;
	@Autowired
	private NoteServc noteServc;
	@Autowired
	private DiscussServc discussServc;
	@Autowired
	private CarouselServc carouselServc;
    private List<File> coursefile ;  
    private List<String> coursefileFileName ;  
    private List<String> coursefileContentType ;
    private String[] rencentweek1;
    private String[] rencentweek2;
    private String pageNumber;
	private int[] pageDirection = new int[2];
	private int[] pageDirectioni = new int[2];
	private int[] pageDirectionNumber = new int[2];
	private int[] pageDirectionNumberi = new int[2];
	private List<Integer> pages = new ArrayList<Integer>();
	private List<Course> tempCourse = new ArrayList<Course>();
	private List<CourseVo> listCourse = new ArrayList<CourseVo>();
	private List<CourseVo> tempListCourse = new ArrayList<CourseVo>();
	private List<Note> listNote = new ArrayList<Note>();
	private List<Discuss> listDiscuss = new ArrayList<Discuss>();
	private List<Carousel> listCarousel = new ArrayList<Carousel>();
	private String courseName;
	private String queryInfo;
	private String resultinfo;
	private int noteSize;
	private int discussSize;
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
		String realpath = ServerInfo.SOURCEFILE_REALPATH + "courseimage";
//		String realpath = ServletActionContext.getServletContext().getRealPath("sourcefile/courseimage");
		System.out.println(realpath);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(tempTime);
		course.setTime(date);
		course.setFace(fileUtils.generateCourseImage(infos[1], realpath,coursefileFileName.get(0)));
		teacher = (Teacher) this.getSesion().get("Teacher");
		course.setTeacher(teacher);
		course.setStreamid(StreamUtils.getStreamId(teacher.getRoomid(),tempTime));
		course.setCoursetype(0);
		course.setAddress("http://" + ServerInfo.BIZID + ".liveplay.myqcloud.com/live/" + ServerInfo.BIZID + "_"+teacher.getRoomid());
		servc.save(course);
		return "save";
	}
	//管理员查找所有直播课程
	public String findAll() {
		listCourse.clear();
		pages.clear();
		listCourse = dateUtils.formatDateTime(servc.findAll(""));
		int temp = countAllPage11.getAllPage(listCourse.size());
		pageDirection = countAllPage11.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage11.getDirectionNumber(1, temp);
		this.getSesion().put("allLiveCoursePage",temp);
		this.getSesion().put("liveCourseList", listCourse);
		pages = countAllPage11.getStartPages(temp);
		return "findAll";
	}
	//教师查找属于自己的所有直播课程
	public String findByTeacherId() {
		String userType = this.getSesion().get("userType").toString();
		if(userType.equals("1")) {
			teacher = (Teacher) this.getSesion().get("Teacher");
			listCourse.clear();
			pages.clear();
			listCourse = dateUtils.formatDateTime(servc.findByTeacherId(String.valueOf(teacher.getId())));
			int temp = countAllPage11.getAllPage(listCourse.size());
			pageDirection = countAllPage11.getLeftAndRight(0,temp);
			pageDirectionNumber = countAllPage11.getDirectionNumber(1, temp);
			this.getSesion().put("allLiveCoursePage",temp);
			this.getSesion().put("liveCourseList", listCourse);
			pages = countAllPage11.getStartPages(temp);
			return "findByTeacherId";			
		}else {
			return "adminFindAll";
		}
	}
	//教师根据页码查找所有直播课程
	public String findByPageNumber() {
		tempListCourse.clear();
		listCourse.clear();
		pages.clear();
		int page = Integer.parseInt(pageNumber);
		int all = Integer.parseInt(this.getSesion().get("allLiveCoursePage").toString());
		pageDirection = countAllPage11.getLeftAndRight(page,all);
		pageDirectionNumber = countAllPage11.getDirectionNumber(page,all);
		tempListCourse = (List<CourseVo>) this.getSesion().get("liveCourseList");
		listCourse = tempListCourse.subList((page-1)*11,countAllPage11.getLastIndex(page,tempListCourse.size()));
		pages.clear();	
		pages = countAllPage11.getPages(Integer.parseInt(pageNumber),Integer.parseInt(this.getSesion().get("allLiveCoursePage").toString()));
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
	//更新课程
	public String update() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		flagCourse = servc.findById(this.getSesion().get("updateCourseId").toString());
		String tempTime = request.getParameter("time");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String summary = request.getParameter("summary");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(tempTime);
		flagCourse.setTime(date);
		flagCourse.setName(name);
		flagCourse.setSubject(subject);
		flagCourse.setSummary(summary);
		servc.update(flagCourse);
		return "update";
	}
	//直播主页
	public String findRecentCource() throws ParseException {
		listCourse.clear();
		pages.clear();
		listCarousel.clear();
		rencentweek1 = dateUtils.getRecentWeek1();
		rencentweek2 = dateUtils.getRecentWeek2();
		SimpleDateFormat sdf1 =  new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat sdf2 =  new SimpleDateFormat("MM-dd");
		listCarousel = carouselServc.findAll("");
		String[] arrayCarousel = new String[listCarousel.size()];
		for(int i = 0;i < arrayCarousel.length;i ++) {
			arrayCarousel[i] = listCarousel.get(i).getFace();
		}
		this.getSesion().put("arrayCarousel",arrayCarousel);
		Date d = new Date();
		String temptoday = sdf1.format(d);
		listCourse = dateUtils.formatDateAndTeacher(servc.findByDate(temptoday));
		int temp = countAllPage6.getAllPage(listCourse.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.getSesion().put("allRecentCoursePage",temp);
		this.getSesion().put("recentCourseList",listCourse);
		pages = countAllPage6.getStartPages(temp);
		this.pageNumber = "1";
		return "findRecentCource";
	}
	//直播主页2
	public String findRecentCourceTemp() throws ParseException {
		listCourse.clear();
		pages.clear();
		rencentweek1 = dateUtils.getRecentWeek1();
		rencentweek2 = dateUtils.getRecentWeek2();
		SimpleDateFormat sdf1 =  new SimpleDateFormat("YYYY-MM-dd");
		SimpleDateFormat sdf2 =  new SimpleDateFormat("MM-dd");
		Date d = new Date();
		String temptoday = sdf1.format(d);
		listCourse = dateUtils.formatDateAndTeacher(servc.findByDate(temptoday));
		int temp = countAllPage6.getAllPage(listCourse.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.getSesion().put("allRecentCoursePage",temp);
		this.getSesion().put("recentCourseList",listCourse);
		pages = countAllPage6.getStartPages(temp);
		this.pageNumber = "1";
		return "findRecentCourceTemp";
	}
	//教学回顾 前台
	public String findPastCource() throws ParseException {
		listCourse.clear();
		pages.clear();
		listCarousel.clear();
		SimpleDateFormat sdf1 =  new SimpleDateFormat("YYYY-MM-dd");
		Date d = new Date();
		String temptoday = sdf1.format(d);
		listCarousel = carouselServc.findAll("");
		String[] arrayCarousel = new String[listCarousel.size()];
		for(int i = 0;i < arrayCarousel.length;i ++) {
			arrayCarousel[i] = listCarousel.get(i).getFace();
		}
		this.getSesion().put("arrayCarousel",arrayCarousel);
		listCourse = dateUtils.formatDateAndTeacher(servc.findPast(temptoday));
		int temp = countAllPage6.getAllPage(listCourse.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.getSesion().put("allPastCoursePage",temp);
		this.getSesion().put("pastCourseList",listCourse);
		pages = countAllPage6.getStartPages(temp);
		this.pageNumber = "1";
		return "findPastCource";
	}
	//教学回顾 前台2
	public String findPastCourceTemp() throws ParseException {
		listCourse.clear();
		pages.clear();
		SimpleDateFormat sdf1 =  new SimpleDateFormat("YYYY-MM-dd");
		Date d = new Date();
		String temptoday = sdf1.format(d);
		listCourse = dateUtils.formatDateAndTeacher(servc.findPast(temptoday));
		int temp = countAllPage6.getAllPage(listCourse.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.getSesion().put("allPastCoursePage",temp);
		this.getSesion().put("pastCourseList",listCourse);
		pages = countAllPage6.getStartPages(temp);
		this.pageNumber = "1";
		return "findPastCourceTemp";
	}
	//教学回顾 后台
	public String teacherFindPastCource() throws ParseException {
		teacher = (Teacher) this.getSesion().get("Teacher");
		listCourse.clear();
		pages.clear();
		listCourse = dateUtils.formatDateTime(servc.findPastCourse(String.valueOf(teacher.getId())));
		int temp = countAllPage11.getAllPage(listCourse.size());
		pageDirection = countAllPage11.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage11.getDirectionNumber(1, temp);
		pages = countAllPage11.getStartPages(temp);
		this.pageNumber = "1";
		return "teacherFindPastCource";
	}
	//教学回顾 后台 根据指定信息查找课程
	public String teacherFindPastCourceByInfo() throws ParseException {
		teacher = (Teacher) this.getSesion().get("Teacher");
		listCourse.clear();
		pages.clear();
		listCourse = dateUtils.formatDateTime(servc.findPastCourseByInfo(courseName,String.valueOf(teacher.getId())));
		int temp = countAllPage11.getAllPage(listCourse.size());
		pageDirection = countAllPage11.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage11.getDirectionNumber(1, temp);
		pages = countAllPage11.getStartPages(temp);
		this.pageNumber = "1";
		return "teacherFindPastCource";
	}
	//教学回顾根据指定日期查找相应的课程
	public String findPastCourceByDate() throws ParseException {
		listCourse.clear();
		pages.clear();
		HttpServletRequest request =  ServletActionContext.getRequest();
		String tempDate = request.getParameter("courseDate").toString();
		this.getSesion().put("tempCourseDate",tempDate);
		String[] courseDates = request.getParameter("courseDate").split("/");		
		String courseDate = courseDates[2] + "-" + courseDates[0] + "-" + courseDates[1];
		SimpleDateFormat sdf1 =  new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf1.parse(courseDate);
		String realDate = sdf1.format(d);
		listCourse = dateUtils.formatDateAndTeacher(servc.findPastByDate(realDate));
		int temp = countAllPage6.getAllPage(listCourse.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.getSesion().put("allPastCoursePage",temp);
		this.getSesion().put("pastCourseList",listCourse);
		pages = countAllPage6.getStartPages(temp);
		this.pageNumber = "1";
		return "findPastCource";
	}
	//前台用户查看教学回顾
	public String studentFindByInfo() throws ParseException {
		listCourse.clear();
		pages.clear();
		tempCourse.clear();
		SimpleDateFormat sdf1 =  new SimpleDateFormat("YYYY-MM-dd");
		Date d = new Date();
		String temptoday = sdf1.format(d);
		tempCourse.addAll((servc.findPastByInfo(temptoday,queryInfo)));
		listCourse = dateUtils.formatDateAndTeacher(tempCourse);
		int temp = countAllPage6.getAllPage(listCourse.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.getSesion().put("allPastCoursePage",temp);
		this.getSesion().put("pastCourseList",listCourse);
		pages = countAllPage6.getStartPages(temp);
		this.pageNumber = "1";
		return "findPastCource";
	}
	//根据页码查找最近课程
	public String findRecentByPage() throws ParseException {
		pages.clear();
		tempListCourse.clear();
		listCourse.clear();
		tempListCourse.clear();
		rencentweek1 = dateUtils.getRecentWeek1();
		rencentweek2 = dateUtils.getRecentWeek2();
		int page = Integer.parseInt(pageNumber);
		int all = Integer.parseInt(this.getSesion().get("allRecentCoursePage").toString());
		pageDirectioni = countAllPage6.getLeftAndRight(page,all);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(page,all);
		tempListCourse = (List<CourseVo>) this.getSesion().get("recentCourseList");
		listCourse = tempListCourse.subList((page-1)*6,countAllPage6.getLastIndex(page,tempListCourse.size()));
		pages = countAllPage6.getPages(Integer.parseInt(pageNumber),all);
		return "findRecentCource";
	}
	//根据页码查找往期课程
	public String findPastByPage() throws ParseException {
		pages.clear();
		tempListCourse.clear();
		listCourse.clear();
		tempListCourse.clear();
		int page = Integer.parseInt(pageNumber);
		int all = Integer.parseInt(this.getSesion().get("allPastCoursePage").toString());
		pageDirectioni = countAllPage6.getLeftAndRight(page,all);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(page,all);
		tempListCourse = (List<CourseVo>) this.getSesion().get("pastCourseList");
		listCourse = tempListCourse.subList((page-1)*6,countAllPage6.getLastIndex(page,tempListCourse.size()));
		pages = countAllPage6.getPages(Integer.parseInt(pageNumber),all);
		return "findPastCource";
	}
	//通过日期查找对应的课程
	public String findByDate() throws ParseException {
		listCourse.clear();
		pages.clear();
		listCourse.clear();
		HttpServletRequest request =  ServletActionContext.getRequest();
		String sdate = request.getParameter("sdate");
		rencentweek1 = dateUtils.getRecentWeek1();
		rencentweek2 = dateUtils.getRecentWeek2();
		SimpleDateFormat sdf1 =  new SimpleDateFormat("YYYY-"+sdate);
		Date d = new Date();
		String day = sdf1.format(d);
		listCourse = dateUtils.formatDateAndTeacher(servc.findByDate(day));
		int temp = countAllPage6.getAllPage(listCourse.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.getSesion().put("allRecentCoursePage",temp);
		this.getSesion().put("recentCourseList",listCourse);
		pages = countAllPage6.getStartPages(temp);
		this.pageNumber = "1";
		return "findRecentCource";
	}
	//观看视频
	public String watch1() throws Exception {
		student = (Student) this.getSesion().get("Student");
		listNote.clear();
		listDiscuss.clear();
		HttpServletRequest request =  ServletActionContext.getRequest();
		String tempId = request.getParameter("courseId");
		course = servc.findByCourseId(tempId);
		courseVo.setTeacher(course.getTeacher().getName());
		courseVo.setCourse(course);
		listNote = noteServc.findAll(String.valueOf(student.getId()),tempId);
		listDiscuss = discussServc.findByCourseId(tempId);
		this.getSesion().put("liveCourse",course);
		this.getSesion().put("liveAddress",course.getAddress());
		this.noteSize = listNote.size();
		this.discussSize = listDiscuss.size();
		return "watch1";			
	}
	//观看视频2
	public String watch2() throws Exception {
		
		listNote.clear();
		listDiscuss.clear();
		HttpServletRequest request =  ServletActionContext.getRequest();
		String tempId = request.getParameter("courseId");
		student = (Student) this.getSesion().get("Student");
		course = servc.findByCourseId(tempId);
		courseVo.setTeacher(course.getTeacher().getName());
		courseVo.setCourse(course);
		listNote = noteServc.findAll(String.valueOf(student.getId()),tempId);
		listDiscuss = discussServc.findByCourseId(tempId);
		this.getSesion().put("liveCourse",course);
		this.getSesion().put("liveAddress",course.getAddress());
		this.noteSize = listNote.size();
		this.discussSize = listDiscuss.size();
		
		return "watch2";
	}
	//直播回调函数
	public String callback() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
		sb.append(temp);
		}
		br.close();
		String params = "[" + sb.toString() + "]";
       	JSONArray jsonArray = JSONArray.fromObject(params);
       	JSONObject jsonObject = jsonArray.getJSONObject(0);
       	String tempStreamId = jsonObject.get("channel_id").toString();
       	String streamId = ServerInfo.STREAM_SHORT + tempStreamId + "?" + (jsonObject.get("stream_param").toString());
       	int event_type = Integer.parseInt(jsonObject.get("event_type").toString());
       	if(event_type==100) {
       		course = servc.findByStreamId(streamId);
       		String address = (String) jsonObject.get("video_url");
       		course.setAddress(address);
       		course.setCoursetype(1);
       		servc.save(course);
       	}else {
       		;
       	}		
		return null;
	}
	//查看课程信息
	public String showInfo() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String courseId = request.getParameter("courseId");
		course = servc.findByCourseId(courseId);
		String[] infos = course.getStreamid().split("/");
		courseVo.setTeacher(course.getTeacher().getName());
		courseVo.setCourse(course);				
		courseVo.setLiveId(ServerInfo.STREAMID);
		courseVo.setStreamId(infos[infos.length-1]);	
		return "showInfo";
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
	public String[] getRencentweek1() {
		return rencentweek1;
	}
	public void setRencentweek1(String[] rencentweek1) {
		this.rencentweek1 = rencentweek1;
	}
	public String[] getRencentweek2() {
		return rencentweek2;
	}
	public void setRencentweek2(String[] rencentweek2) {
		this.rencentweek2 = rencentweek2;
	}
	public CountAllPage11 getCountAllPage11() {
		return countAllPage11;
	}
	public void setCountAllPage11(CountAllPage11 countAllPage11) {
		this.countAllPage11 = countAllPage11;
	}
	public CountAllPage6 getCountAllPage6() {
		return countAllPage6;
	}
	public void setCountAllPage6(CountAllPage6 countAllPage6) {
		this.countAllPage6 = countAllPage6;
	}
	public int[] getPageDirectioni() {
		return pageDirectioni;
	}
	public void setPageDirectioni(int[] pageDirectioni) {
		this.pageDirectioni = pageDirectioni;
	}
	public int[] getPageDirectionNumberi() {
		return pageDirectionNumberi;
	}
	public void setPageDirectionNumberi(int[] pageDirectionNumberi) {
		this.pageDirectionNumberi = pageDirectionNumberi;
	}
	public String getQueryInfo() {
		return queryInfo;
	}
	public void setQueryInfo(String queryInfo) {
		this.queryInfo = queryInfo;
	}
	public List<Note> getListNote() {
		return listNote;
	}
	public void setListNote(List<Note> listNote) {
		this.listNote = listNote;
	}
	public List<Discuss> getListDiscuss() {
		return listDiscuss;
	}
	public void setListDiscuss(List<Discuss> listDiscuss) {
		this.listDiscuss = listDiscuss;
	}
	public int getNoteSize() {
		return noteSize;
	}
	public void setNoteSize(int noteSize) {
		this.noteSize = noteSize;
	}
	public int getDiscussSize() {
		return discussSize;
	}
	public void setDiscussSize(int discussSize) {
		this.discussSize = discussSize;
	}
}
