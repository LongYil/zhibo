package cn.lxy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.ExamDaoImpl;
import cn.lxy.po.Exam;
import cn.lxy.utils.AssembleExam;
import cn.lxy.vo.ExamVo;

@Transactional
@Service(value="examServc")
public class ExamServc extends CommonSevc<Exam, ExamDaoImpl> {
	
	@Autowired
	private AssembleExam assembleExam;
	
	private List<Exam> listExam = new ArrayList<Exam>();
	@Override
	public void save(Exam arg) {
		daoImpl.save(arg);		
	}

	@Override
	public Exam find(String arg) throws Exception {
		//
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
	
}
