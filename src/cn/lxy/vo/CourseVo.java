package cn.lxy.vo;

import org.springframework.stereotype.Component;

import cn.lxy.po.Course;

/**
 * <p>Title:CourseVo</p>
 * <p>Description: �γ�ʵ���װ��</p>
 * @author ������
 *		2017��11��26��
 *		����11:17:15
 */
@Component
public class CourseVo {
	private Course course;
	private String time;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
