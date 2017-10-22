package cn.lxy.po;

/**
 * <p>Title:Course</p>
 * <p>Description:课程实体 </p>
 * @author 李银龙
 *		2017年10月22日
 *		下午11:58:31
 */
public class Course {
	private Integer id;//序号
	private Integer teacher_id;//教师编号
	private String name;//课程名称
	private String summary;//课程简介
	private String face;//封面
	private String time;//开始时间
	private String address;//课程地址
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
