package cn.lxy.vo;

import cn.lxy.po.Exam;

/**
 * <p>Title:ExamVo</p>
 * <p>Description: ����ʵ���װ��</p>
 * @author ������
 *		2017��11��17��
 *		����9:56:34
 */
public class ExamVo {
	private Exam exam;
	private String teacherName;
	private String time;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}	
	
}
