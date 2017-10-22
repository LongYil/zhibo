package cn.lxy.po;

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
	
}
