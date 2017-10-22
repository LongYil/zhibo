package cn.lxy.po;

/**
 * <p>Title:Carousel</p>
 * <p>Description:轮播实体 </p>
 * @author 李银龙
 *		2017年10月23日
 *		上午12:14:53
 */
public class Carousel {
	private Integer id;//序号
	private String face;//封面地址
	private String address;//课程地址
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
