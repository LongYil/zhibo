package cn.lxy.po;

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
	private String username;//用户名
	private String name;//学生姓名
	private String password;//密码
	private Character tel;//手机号
	private String head;//头像地址
	
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
	public Character getTel() {
		return tel;
	}
	public void setTel(Character tel) {
		this.tel = tel;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
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

	
}
