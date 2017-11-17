package cn.lxy.vo;

import cn.lxy.po.Exam;

/**
 * <p>Title:ExamVo</p>
 * <p>Description: 试题实体包装类</p>
 * @author 李银龙
 *		2017年11月17日
 *		下午9:56:34
 */
public class ExamVo {
	private Exam exam;
	private String teacherName;
	
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}	
}
