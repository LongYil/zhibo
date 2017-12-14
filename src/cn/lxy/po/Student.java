package cn.lxy.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title:Student</p>
 * <p>Description: 学生</p>
 * @author 李银龙
 *		2017年10月23日
 *		上午12:08:11
 */
public class Student {
	private Integer id;//序号
	private Integer userstatus;//学生状态  1：可用  0：禁用   禁用后不可登录系统
	private String username;//用户名
	private String name;//学生姓名
	private String password;//密码
	private String tel;//手机号
	private Date birth;//生日
	private String head;//头像地址
	private String school;//学校
	private String department;//学院
	private String sex;//性别
	private String classandgrade;//班级
	private String selfintroduce;//自我介绍
	
	//在学生里面表示所拥有的笔记，一个学生拥有多个笔记
	private Set<Note> setNote = new HashSet<Note>();
	//在学生里面表示所拥有的讨论，一个学生可以拥有多个讨论
	private Set<Discuss> setDiscuss = new HashSet<Discuss>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassandgrade() {
		return classandgrade;
	}
	public void setClassandgrade(String classandgrade) {
		this.classandgrade = classandgrade;
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
	public Integer getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(Integer userstatus) {
		this.userstatus = userstatus;
	}
	public String getSelfintroduce() {
		return selfintroduce;
	}
	public void setSelfintroduce(String selfintroduce) {
		this.selfintroduce = selfintroduce;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	
}
