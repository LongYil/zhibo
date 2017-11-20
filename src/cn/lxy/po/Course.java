package cn.lxy.po;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title:Course</p>
 * <p>Description:�γ�ʵ�� </p>
 * @author ������
 *		2017��10��22��
 *		����11:58:31
 */
public class Course {
	private Integer id;//���
	private String name;//�γ�����
	private String subject;//�γ̿�Ŀ
	private String summary;//�γ̼��
	private String face;//����
	private String time;//��ʼʱ��
	private String address;//�γ̵�ַ
	//�ڿγ������ʾ������ʦ��һ���γ�ֻ������һ����ʦ
	private Teacher teacher;
	//�ڿγ������ʾ��ӵ�еıʼǣ�һ���γ�ӵ�ж���ʼ�
	private Set<Note> setNote = new HashSet<Note>();
	//�ڿγ������ʾ��ӵ�е����ۣ�һ���γ�ӵ�ж������
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	
}
