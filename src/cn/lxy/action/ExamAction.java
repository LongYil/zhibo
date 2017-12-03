package cn.lxy.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Exam;
import cn.lxy.po.Teacher;
import cn.lxy.service.ExamServc;
import cn.lxy.utils.CountAllPage;
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
	private CountAllPage countAllPage;	
	
	
	private List<ExamVo> listExamVo = new ArrayList<ExamVo>();
	private List<ExamVo> tempListExamVo = new ArrayList<ExamVo>();
	private List<Integer> pages = new ArrayList<Integer>();
	private List<AnalysedExam> listAnalysedExam = new ArrayList<AnalysedExam>();
	private List<String> listAnswerResult = new ArrayList<String>();
	
	private String resultinfo;
	private String pageNumber;
	private String queryInfo;
	
	private String examId;
	
	private int[] pageDirection = new int[2];
	private int[] pageDirectionNumber = new int[2];
	
    private String usename ;  
    private List<File> examfile ;  
    private List<String> examfileFileName ;  
    private List<String> examfileContentType ;
    
	
	@Override
	public Exam getModel() {
		return exam;
	}
	//查找所有试题
	public String findAll() {
		if(listExamVo!=null) {
			listExamVo.clear();
		}else {
			;
		}
		pages.clear();
		listExamVo = servc.findAll();
		int temp = countAllPage.getAllPage(listExamVo.size());
		pageDirection = countAllPage.getLeftAndRight(0,temp);
		pageDirectionNumber = countAllPage.getDirectionNumber(1, temp);
		this.pageNumber="1";
		this.getSesion().put("allExamPage",temp);
		this.getSesion().put("examList", listExamVo);
		pages = countAllPage.getStartPages(temp);
		return "findAll";
	}
	//根据页码查找对应页面的试题
	public String findByPageNumber() {
		int page = Integer.parseInt(pageNumber);
		int all = Integer.parseInt(this.getSesion().get("allExamPage").toString());
		pageDirection = countAllPage.getLeftAndRight(page,all);
		pageDirectionNumber = countAllPage.getDirectionNumber(page,all);
		tempListExamVo = (List<ExamVo>) this.getSesion().get("examList");
		listExamVo = tempListExamVo.subList((page-1)*11,countAllPage.getLastIndex(page,tempListExamVo.size()));
		pages.clear();
		pages = countAllPage.getPages(Integer.parseInt(pageNumber),Integer.parseInt(this.getSesion().get("allExamPage").toString()));
		return "findAll";
	}
	//根据试题名称或描述查找对应的试题
	public String findByName() {
		listExamVo.clear();
		listExamVo = servc.findByName(queryInfo);
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
		servc.save(exam);
        return "save";
	}
	//根据试题id解析试题
	public String analyseExam() throws BiffException, IOException {
//		servc.analyseExam(examId);
		listAnalysedExam = servc.analyseExam("3");
		this.getSesion().put("analysedExamList", listAnalysedExam);
		return "analyseExam";
	}
	//根据答题情况计算结果
	public String calculateResult() {
		String[] results = null;//前台传来的答题结果
		listAnalysedExam.clear();
		listAnalysedExam = (List<AnalysedExam>) this.getSesion().get("analysedExamList");
		listAnswerResult.clear();
		listAnswerResult = servc.calculateResult(results, listAnalysedExam);
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
	
}
