package cn.lxy.po;

/**
 * <p>Title:Note</p>
 * <p>Description:笔记实体 </p>
 * @author 李银龙
 *		2017年10月23日
 *		上午12:10:43
 */

public class Note {
	private Integer id;//序号
	private String time;//记录时间
	private String content;//记录内容
	//在笔记里面表示所属课程，一条笔记只能属于一个课程
	private Course course;
	//在笔记里面表示所属学生，一条笔记只能属于一个学生
	private Student student;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

}
