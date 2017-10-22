package cn.lxy.po;

/**
 * <p>Title:Manager</p>
 * <p>Description:系统管理员 </p>
 * @author 李银龙
 *		2017年10月23日
 *		上午12:16:53
 */
public class Manager {
	private Integer id;//序号
	private String username;//用户名
	private String password;//密码
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
