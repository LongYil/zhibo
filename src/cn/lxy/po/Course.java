package cn.lxy.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

/**
 * <p>Title:Course</p>
 * <p>Description:课程实体 </p>
 * @author 李银龙
 *		2017年10月22日
 *		下午11:58:31
 */
public class Course {
	private Integer id;//序号
	private String name;//课程名称
	private Integer coursetype;//课程类型  0：直播课程 1：往期课程
	private String subject;//课程科目
	private String summary;//课程简介
	private String face;//封面
	private Date time;//开始时间
	private String address;//课程地址
	private String streamid;//串流码
	//在课程里面表示所属教师，一个课程只能属于一个教师
	private Teacher teacher;
	//在课程里面表示所拥有的笔记，一个课程拥有多个笔记
	private Set<Note> setNote = new HashSet<Note>();
	//在课程里面表示所拥有的讨论，一个课程拥有多个讨论
	private Set<Discuss> setDiscuss = new HashSet<Discuss>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStreamid() {
		return streamid;
	}
	public void setStreamid(String streamid) {
		this.streamid = streamid;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Set<Note> getSetNote() {
		return setNote;
	}
	public void setSetNote(Set<Note> setNote) {
		this.setNote = setNote;
	}
	public Set<Discuss> getSetDiscuss() {
		return setDiscuss;
	}
	public void setSetDiscuss(Set<Discuss> setDiscuss) {
		this.setDiscuss = setDiscuss;
	}
	public Integer getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(Integer coursetype) {
		this.coursetype = coursetype;
	}
	
	
}
