package cn.lxy.po;


/**
 * <p>Title:Exam</p>
 * <p>Description:����ʵ�� </p>
 * @author ������
 *		2017��10��23��
 *		����12:06:12
 */
public class Exam {
	private Integer id;
	private String name;//��������
	private String face;//�������url
	private String describes;//��������
	private String fileaddress;//���⸽�� url
	//�����������ʾ������ʦ��һ������ֻ������һ����ʦ
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
