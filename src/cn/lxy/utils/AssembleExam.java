package cn.lxy.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.lxy.po.Exam;
import cn.lxy.vo.ExamVo;

@Component(value="assembleExam")
public class AssembleExam {
	private List<ExamVo> listvo = new ArrayList<ExamVo>();
	private ExamVo examVo;
	
	public List<ExamVo> getExamVo(List<Exam> list){
		listvo.clear();
		for(int i=0;i<list.size();i++) {
			examVo = new ExamVo();
			examVo.setExam(list.get(i));
			examVo.setTeacherName(list.get(i).getTeacher().getName());
			listvo.add(examVo);
		}
		return listvo;
	}
	
	
}
