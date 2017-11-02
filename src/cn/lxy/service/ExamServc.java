package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.ExamDaoImpl;
import cn.lxy.po.Exam;

@Transactional
@Service(value="examServc")
public class ExamServc extends CommonSevc<Exam, ExamDaoImpl> {

	@Override
	public void save(Exam arg) {
		//
		
	}

	@Override
	public Exam find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<Exam> findAll(String arg) {
		//
		return null;
	}

	@Override
	public void delete(Exam arg) {
		//
		
	}

}
