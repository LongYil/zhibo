package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Carousel;
import cn.lxy.service.CarouselServc;

/**
 * <p>Title:CarouselAction</p>
 * <p>Description: 轮播实体控制器</p>
 * @author 李银龙
 *		2017年11月20日
 *		下午9:50:31
 */
public class CarouselAction extends BasicAction implements ModelDriven<Carousel>{
	
	@Autowired
	private Carousel carousel;

	@Override
	public Carousel getModel() {
		return carousel;
	}

	
	
	public Carousel getCarousel() {
		return carousel;
	}
	public void setCarousel(Carousel carousel) {
		this.carousel = carousel;
	}

	
}
