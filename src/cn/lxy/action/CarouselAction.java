package cn.lxy.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Carousel;
import cn.lxy.service.CarouselServc;
import cn.lxy.utils.FileUtils;

/**
 * <p>Title:CarouselAction</p>
 * <p>Description: 轮播实体控制器</p>
 * @author 李银龙
 *		2017年11月20日
 *		下午9:50:31
 */
public class CarouselAction extends BasicAction implements ModelDriven<Carousel>{
	@Autowired
	private Carousel tempCarousel;
	@Autowired
	private CarouselServc servc;
	@Autowired
	private FileUtils fileUtils;
    private List<File> imgfile;
    private List<String> imgfileFileName ;  
    private List<String> imgfileContentType ;
    private List<Carousel> listImg = new ArrayList<Carousel>();
    private String resultinfo;
    private Carousel carousel;
	
	@Override
	public Carousel getModel() {
		return carousel;
	}
	//保存轮播图片
	public String addImg() throws Exception {
		for(int i = 0;i < imgfile.size();i ++) {
			if(imgfile.get(i) != null) {
				String realpath = ServletActionContext.getServletContext().getRealPath("/Image");
				carousel = new Carousel();
				carousel.setFace(fileUtils.saveImg(imgfile.get(i),realpath,imgfileFileName.get(i)));
				servc.save(carousel);
			}
		}
		return "addImg";
	}
	//查找所有轮播图片
	public String findAll() {
		listImg.clear();
		listImg = servc.findAll("");
		return "findAll";
	}
	//预上传图片
	public String uploadImg() {
		return "uploadImg";
	}
	//删除图片
	public String deleteImg() throws Exception {
		this.resultinfo = "0";
		HttpServletRequest request =  ServletActionContext.getRequest();
		String carouselId = request.getParameter("info");
		tempCarousel = servc.find(carouselId);
		servc.delete(tempCarousel);
		this.resultinfo = "1";
		return "deleteImg";
	}
	public Carousel getCarousel() {
		return carousel;
	}
	public void setCarousel(Carousel carousel) {
		this.carousel = carousel;
	}
	public List<Carousel> getListImg() {
		return listImg;
	}
	public void setListImg(List<Carousel> listImg) {
		this.listImg = listImg;
	}
	public List<File> getImgfile() {
		return imgfile;
	}
	public void setImgfile(List<File> imgfile) {
		this.imgfile = imgfile;
	}
	public List<String> getImgfileFileName() {
		return imgfileFileName;
	}
	public void setImgfileFileName(List<String> imgfileFileName) {
		this.imgfileFileName = imgfileFileName;
	}
	public List<String> getImgfileContentType() {
		return imgfileContentType;
	}
	public void setImgfileContentType(List<String> imgfileContentType) {
		this.imgfileContentType = imgfileContentType;
	}
	public String getResultinfo() {
		return resultinfo;
	}
	public void setResultinfo(String resultinfo) {
		this.resultinfo = resultinfo;
	}
}
