package cn.lxy.vo;

import org.springframework.stereotype.Component;

import cn.lxy.po.Course;

/**
 * <p>Title:CourseVo</p>
 * <p>Description: 课程实体包装类</p>
 * @author 李银龙
 *		2017年11月26日
 *		上午11:17:15
 */
@Component
public class CourseVo {
	private Course course;
	private String time;
	private String teacher;
	
	private String liveId;//直播码
	private String streamId;//串流码
	
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
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getLiveId() {
		return liveId;
	}
	public void setLiveId(String liveId) {
		this.liveId = liveId;
	}
	public String getStreamId() {
		return streamId;
	}
	public void setStreamId(String streamId) {
		this.streamId = streamId;
	}
	
}
