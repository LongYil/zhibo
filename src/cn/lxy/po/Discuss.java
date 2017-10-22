package cn.lxy.po;

/**
 * <p>Title:Discuss</p>
 * <p>Description:讨论实体 </p>
 * @author 李银龙
 *		2017年10月23日
 *		上午12:12:41
 */
public class Discuss {
	private Integer id;//序号
	private Integer course_id;//课程id
	private Integer student_id;//学生id
	private String time;//发表时间
	private String content;//发表内容
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
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
	

}
