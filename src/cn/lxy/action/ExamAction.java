package cn.lxy.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Exam;
import cn.lxy.po.Student;
import cn.lxy.service.ExamServc;
import cn.lxy.utils.CountAllPage;
import cn.lxy.vo.ExamVo;

public class ExamAction extends BasicAction implements ModelDriven<Exam> {
	@Autowired
	private Exam exam;
	@Autowired
	private ExamServc servc;
	
	private List<ExamVo> listExamVo = new ArrayList<ExamVo>();
	private List<ExamVo> tempListExamVo = new ArrayList<ExamVo>();
	private List<Integer> pages = new ArrayList<Integer>();
	
	private String resultinfo;
	private String pageNumber;
	private String queryInfo;
	
	private int[] pageDirection = new int[2];
	private int[] pageDirectionNumber = new int[2];
	
	@Autowired
	private CountAllPage countAllPage;	
	
	
	
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
		System.out.println(queryInfo);
		listExamVo = servc.findByName(queryInfo);
		return "findByName";
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
	
	


	
}
