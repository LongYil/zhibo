package cn.lxy.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import cn.lxy.po.Carousel;
import cn.lxy.service.CarouselServc;

public class CarouselAction extends BasicAction<CarouselServc> implements ModelDriven<Carousel>{
	
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
