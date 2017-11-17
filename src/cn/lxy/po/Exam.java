package cn.lxy.po;


/**
 * <p>Title:Exam</p>
 * <p>Description:试题实体 </p>
 * @author 李银龙
 *		2017年10月23日
 *		上午12:06:12
 */
public class Exam {
	private Integer id;
	private String name;//试题名称
	private String face;//试题封面url
	private String describes;//试题描述
	private String fileaddress;//试题附件 url
	//在试题里面表示所属教师，一个试题只能属于一个教师
	private Teacher teacher;
	
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
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getDescribes() {
		return describes;
	}
	public void setDescribes(String describes) {
		this.describes = describes;
	}
	public String getFileaddress() {
		return fileaddress;
	}
	public void setFileaddress(String fileaddress) {
		this.fileaddress = fileaddress;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
