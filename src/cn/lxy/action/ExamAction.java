package cn.lxy.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Carousel;
import cn.lxy.po.Exam;
import cn.lxy.po.Teacher;
import cn.lxy.service.CarouselServc;
import cn.lxy.service.ExamServc;
import cn.lxy.utils.CountAllPage11;
import cn.lxy.utils.CountAllPage6;
import cn.lxy.utils.FileUtils;
import cn.lxy.vo.AnalysedExam;
import cn.lxy.vo.ExamVo;
import jxl.read.biff.BiffException;

/**
 * <p>Title:ExamAction</p>
 * <p>Description: 试题实体控制器</p>
 * @author 李银龙
 *		2017年11月20日
 *		下午9:51:45
 */
public class ExamAction extends BasicAction implements ModelDriven<Exam> {
	@Autowired
	private Exam exam;
	@Autowired
	private ExamServc servc;
	@Autowired
	private FileUtils fileUtils;
	@Autowired
	private Teacher teacher;
	@Autowired
	private CountAllPage11 countAllPage11;	
	@Autowired
	private CountAllPage6 countAllPage6;
	private List<ExamVo> listExamVo = new ArrayList<ExamVo>();
	private List<ExamVo> tempListExamVo = new ArrayList<ExamVo>();
	private List<Integer> pages = new ArrayList<Integer>();
	private List<AnalysedExam> listAnalysedExam = new ArrayList<AnalysedExam>();
	private List<String> listAnswerResult = new ArrayList<String>();
	private String resultinfo;
	private String pageNumber;
	private String queryInfo;
	private String examId;
	private String examNumber;
	private int[] pageDirection = new int[2];
	private int[] pageDirectioni = new int[2];
	private int[] pageDirectionNumber = new int[2];
	private int[] pageDirectionNumberi = new int[2];
    private String usename ;
    private String examName;
    private List<File> examfile;
    private List<String> examfileFileName ;  
    private List<String> examfileContentType ;
	@Override
	public Exam getModel() {
		return exam;
	}
	//学生用户查找所有试题
	public String studentFindAll() {
		listExamVo.clear();
		pages.clear();
		listExamVo = servc.studentFindAll();
		int temp = countAllPage6.getAllPage(listExamVo.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.pageNumber="1";
		this.getSesion().put("studentAllExamPage",temp);
		this.getSesion().put("studentExamList", listExamVo);
		pages = countAllPage6.getStartPages(temp);
		return "studentFindAll";
	}
	//学生用户查找所有试题
	public String studentFindAllTemp() {
		listExamVo.clear();
		pages.clear();
		listExamVo = servc.studentFindAll();
		int temp = countAllPage6.getAllPage(listExamVo.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.pageNumber="1";
		this.getSesion().put("studentAllExamPage",temp);
		this.getSesion().put("studentExamList", listExamVo);
		pages = countAllPage6.getStartPages(temp);
		return "studentFindAllTemp";
	}
	//前台用户根据试题信息查找试题
	public String studentFindByInfo() {
		pages.clear();
		listExamVo.clear();
		listExamVo = servc.studentFindAllByInfo(queryInfo);
		int temp = countAllPage6.getAllPage(listExamVo.size());
		pageDirectioni = countAllPage6.getLeftAndRight(0,temp);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(1, temp);
		this.pageNumber="1";
		this.getSesion().put("studentAllExamPage",temp);
		this.getSesion().put("studentExamList", listExamVo);
		pages = countAllPage6.getStartPages(temp);
		return "studentFindAll";
	}
	//根据页码查找对应页面的试题
	public String studentFindByPageNumber() {
		tempListExamVo.clear();
		pages.clear();
		listExamVo.clear();
		int page = Integer.parseInt(pageNumber);
		int all = Integer.parseInt(this.getSesion().get("studentAllExamPage").toString());
		pageDirectioni = countAllPage6.getLeftAndRight(page,all);
		pageDirectionNumberi = countAllPage6.getDirectionNumber(page,all);
		tempListExamVo = (List<ExamVo>) this.getSesion().get("studentExamList");
		listExamVo = tempListExamVo.subList((page-1)*6,countAllPage6.getLastIndex(page,tempListExamVo.size()));
		pages = countAllPage6.getPages(page,all);
		return "studentFindAll";
	}	
	//后台管理用户查找所有试题
	public String findAll() {
		listExamVo.clear();
		pages.clear();
		int userType = Integer.parseInt(this.getSesion().get("userType").toString());
		if(userType == 1) {
			teacher = (Teacher) this.getSesion().get("Teacher");
			listExamVo = servc.teacherFindAll(String.valueOf(teacher.getId()));
		}else {
			listExamVo = servc.findAll();
		}
		int temp = countAllPage11.getAllPage(listExamVo.size());
		pageDirection = countAllPage11.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage11.getDirectionNumber(1, temp);
		this.pageNumber="1";
		this.getSesion().put("allExamPage",temp);
		this.getSesion().put("examList", listExamVo);
		pages = countAllPage11.getStartPages(temp);
		if(userType == 1) {
			return "teacherFindAll";
		}else {
			return "findAll";
		}
	}
	//根据页码查找对应页面的试题
	public String findByPageNumber() {
		int page = Integer.parseInt(pageNumber);
		int all = Integer.parseInt(this.getSesion().get("allExamPage").toString());
		pageDirection = countAllPage11.getLeftAndRight(page,all);
		pageDirectionNumber = countAllPage11.getDirectionNumber(page,all);
		tempListExamVo = (List<ExamVo>) this.getSesion().get("examList");
		listExamVo = tempListExamVo.subList((page-1)*11,countAllPage11.getLastIndex(page,tempListExamVo.size()));
		pages.clear();
		pages = countAllPage11.getPages(Integer.parseInt(pageNumber),Integer.parseInt(this.getSesion().get("allExamPage").toString()));
		return "findAll";
	}
	//根据试题名称或描述查找对应的试题
	public String findByName() {
		listExamVo.clear();
		int userType = Integer.parseInt(this.getSesion().get("userType").toString());
		if(userType == 1) {
			teacher = (Teacher) this.getSesion().get("Teacher");
			listExamVo = servc.teacherFindByName(queryInfo,String.valueOf(teacher.getId()));
		}else {
			listExamVo = servc.findByName(queryInfo);
		}
		this.getSesion().put("examQueryInfo", queryInfo);
		return "findByName";
	}
	//删除试题
	public String delete() throws Exception {
		this.resultinfo="0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		String examId = request.getParameter("info");
		exam = servc.findById(examId);
		servc.delete(exam);
		this.resultinfo="1";		
		return "delete";
	}
	//删除试题后重新查询
	public String queryAfterDelete() {
		String info = this.getSesion().get("examQueryInfo").toString();
		listExamVo.clear();
		listExamVo = servc.findByName(info);
		return "findByName";		
	}
	//保存试题
	public String save() throws Exception {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String examPic = request.getParameter("examPic");
		String[] infos = examPic.split(",");
		String realpath1 = ServletActionContext.getServletContext().getRealPath("/sourcefile/examimage");
        String realpath2 = ServletActionContext.getServletContext().getRealPath("/sourcefile/examfile"); 
        teacher = (Teacher) this.getSesion().get("Teacher");
        exam.setFace(fileUtils.GenerateImage(infos[1],realpath1,examfileFileName.get(1)));
        exam.setFileaddress(fileUtils.saveFile(examfile.get(0), realpath2,examfileFileName.get(0)));
		exam.setTeacher(teacher);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String time = sdf.format(d);
		Date d2 = sdf.parse(time);
		exam.setTime(d2);
		servc.save(exam);
        return "save";
	}
	//根据试题id解析试题
	public String analyseExam() throws BiffException, IOException {
		HttpServletRequest request =  ServletActionContext.getRequest();
		String examId = request.getParameter("examId");
		examName = servc.findById(examId).getName();
		listAnalysedExam = servc.analyseExam(examId);
		examNumber = String.valueOf(listAnalysedExam.size()+1);
		this.getSesion().put("analysedExamList", listAnalysedExam);
		return "analyseExam";
	}
	//根据答题情况计算结果
	public String calculateResult() throws JSONException {
		HttpServletRequest request = ServletActionContext.getRequest();
		String answer = request.getParameter("info").substring(2);		
		String[] results = answer.split("-");//前台传来的答题结果
		listAnalysedExam.clear();
		listAnalysedExam = (List<AnalysedExam>) this.getSesion().get("analysedExamList");
		listAnswerResult.clear();
		listAnswerResult = servc.calculateResult(results, listAnalysedExam);
        JSONObject jo = new JSONObject();
        StringBuffer calculateresult = new StringBuffer();
        for(int i=0;i<listAnswerResult.size();i++){
        	calculateresult.append("{'result':'"+listAnswerResult.get(i)+"'}");
        	if(i!=(listAnswerResult.size()-1)){
        		calculateresult.append(",");
        	}
        }
        jo.put("info", "["+calculateresult+"]");
        this.resultinfo = jo.toString();
		return "calculateResult";
	}
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public List<ExamVo> getListExamVo() {
		return listExamVo;
	}
	public void setListExamVo(List<ExamVo> listExamVo) {
		this.listExamVo = listExamVo;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	public String getResultinfo() {
		return resultinfo;
	}
	public void setResultinfo(String resultinfo) {
		this.resultinfo = resultinfo;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
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
	public String getQueryInfo() {
		return queryInfo;
	}
	public void setQueryInfo(String queryInfo) {
		this.queryInfo = queryInfo;
	}
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public List<File> getExamfile() {
		return examfile;
	}
	public void setExamfile(List<File> examfile) {
		this.examfile = examfile;
	}
	public List<String> getExamfileFileName() {
		return examfileFileName;
	}
	public void setExamfileFileName(List<String> examfileFileName) {
		this.examfileFileName = examfileFileName;
	}
	public List<String> getExamfileContentType() {
		return examfileContentType;
	}
	public void setExamfileContentType(List<String> examfileContentType) {
		this.examfileContentType = examfileContentType;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
	}
	public List<AnalysedExam> getListAnalysedExam() {
		return listAnalysedExam;
	}
	public void setListAnalysedExam(List<AnalysedExam> listAnalysedExam) {
		this.listAnalysedExam = listAnalysedExam;
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
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamNumber() {
		return examNumber;
	}
	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
	}
	public List<String> getListAnswerResult() {
		return listAnswerResult;
	}
	public void setListAnswerResult(List<String> listAnswerResult) {
		this.listAnswerResult = listAnswerResult;
	}
}
