package cn.lxy.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.ExamDaoImpl;
import cn.lxy.po.Exam;
import cn.lxy.utils.AssembleExam;
import cn.lxy.vo.AnalysedExam;
import cn.lxy.vo.ExamVo;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@Transactional
@Service(value="examServc")
public class ExamServc extends CommonSevc<Exam, ExamDaoImpl> {
	
	@Autowired
	private AssembleExam assembleExam;
	@Autowired
	private Exam exam;
	
	private AnalysedExam analyaedExam;
	
	private List<Exam> listExam = new ArrayList<Exam>();
	private List<AnalysedExam> listResult = new ArrayList<AnalysedExam>();
	private List<String> answerResultList = new ArrayList<String>();
	@Override
	public void save(Exam arg) {
		daoImpl.save(arg);		
	}

	@Override
	public Exam find(String arg) throws Exception {
		
		return null;
	}

	@Override
	public List<Exam> findAll(String arg) {
		return daoImpl.findAll();
	}
	
	public List<ExamVo> findAll(){
		listExam.clear();
		listExam = daoImpl.findAll();
		return assembleExam.getExamVo(listExam);
	}
	public List<ExamVo> studentFindAll(){
		listExam.clear();
		listExam = daoImpl.studentFindAll();
		return assembleExam.getExamVo(listExam);
	}
	
	@Override
	public void delete(Exam arg) {
		daoImpl.delete(arg);
	}
	public List<ExamVo> findByName(String arg){
		String sql = "name like '%"+arg+"%' or describes like '%"+arg+"%' ";
		listExam = daoImpl.findByName(sql);
		return assembleExam.getExamVo(listExam);
	}
	public Exam findById(String arg) {
		return daoImpl.findById(arg);
	}
	public List<AnalysedExam> analyseExam(String arg) throws BiffException, IOException{
		exam = this.findById(arg);
		String fileRealAddress = ServletActionContext.getServletContext().getRealPath("/sourcefile/examfile");
		System.out.println(fileRealAddress);
		String[] tempFileAddress = exam.getFileaddress().split("/");
		Workbook book = Workbook.getWorkbook(new File(fileRealAddress+"/"+tempFileAddress[tempFileAddress.length-1]));	
		Sheet sheet = book.getSheets()[0];
		listResult.clear();
		int j=1;
		try {
			while(sheet.getCell(0,j)!=null&&!sheet.getCell(0,j).getContents().equals("")) {
				   analyaedExam = new AnalysedExam();
				   analyaedExam.setId(j);
				   analyaedExam.setQuestion(sheet.getCell(0, j).getContents());
				   analyaedExam.setOptionA(sheet.getCell(1, j).getContents());
				   analyaedExam.setOptionB(sheet.getCell(2, j).getContents());
				   analyaedExam.setOptionC(sheet.getCell(3, j).getContents());
				   analyaedExam.setOptionD(sheet.getCell(4, j).getContents());
				   analyaedExam.setResult(sheet.getCell(5, j).getContents());
				   listResult.add(analyaedExam);
				   j++;
			}
		}catch(Exception e) {
			return listResult;
		}
		return listResult;
	}
	
	public List<String> calculateResult(String[] arg1,List<AnalysedExam> arg2) {
		answerResultList.clear();
		for(int i=0;i<arg1.length;i++) {
			if(arg1[i].equals(arg2.get(i).getResult())) {
				answerResultList.add((i+1)+":"+arg1+" 正确");
			}else {
				answerResultList.add((i+1)+":"+arg1+" 错误"+"正解:"+arg2.get(i).getResult());
			}
		}
		return answerResultList;
	}
	
	
}
