package cn.lxy.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		for(int i=0;i<list.size();i++) {
			examVo = new ExamVo();
			examVo.setExam(list.get(i));
			examVo.setTime(sdf.format(list.get(i).getTime()));
			examVo.setTeacherName(list.get(i).getTeacher().getName());
			listvo.add(examVo);
		}
		return listvo;
	}
	
	
}
