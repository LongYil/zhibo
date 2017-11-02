package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Exam;
import cn.lxy.service.ExamServc;

public class ExamAction extends BasicAction implements ModelDriven<Exam> {
	@Autowired
	private Exam exam;
	
	@Override
	public Exam getModel() {
		//
		return exam;
	}

}
