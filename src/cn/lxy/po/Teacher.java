package cn.lxy.po;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title:Teacher</p>
 * <p>Description:教师实体 </p>
 * @author 李银龙
 *		2017年10月22日
 *		下午11:25:48
 */
public class Teacher {
	private Integer id;//教师编号 主键
	private String name;//教师姓名
	private String username;//教师用户名
	private String password;//密码
	private Character sex;//性别
	private String subject;//科目
	private String school;//毕业院校
	private String teacthage;//教龄
	private Character tel;//手机号
	private String email;//邮箱
	private String head;//头像地址
	private String fms;//
	private String streamid;//串流码
	//在教师里面表示直播课程，一个教师拥有多个直播课程
	private Set<Course> setCourse = new HashSet<Course>();
	//在教师里面表示试题，一个教师拥有多个试题
	private Set<Exam> setExam = new HashSet<Exam>();
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Character getSex() {
		return sex;
	}
	public void setSex(Character sex) {
		this.sex = sex;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTeacthage() {
		return teacthage;
	}
	public void setTeacthage(String teacthage) {
		this.teacthage = teacthage;
	}
	public Character getTel() {
		return tel;
	}
	public void setTel(Character tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getFms() {
		return fms;
	}
	public void setFms(String fms) {
		this.fms = fms;
	}
	public String getStreamid() {
		return streamid;
	}
	public void setStreamid(String streamid) {
		this.streamid = streamid;
	}
	public Set<Course> getSetCourse() {
		return setCourse;
	}
	public void setSetCourse(Set<Course> setCourse) {
		this.setCourse = setCourse;
	}
	public Set<Exam> getSetExam() {
		return setExam;
	}
	public void setSetExam(Set<Exam> setExam) {
		this.setExam = setExam;
	}	
	
}
