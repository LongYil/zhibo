package cn.lxy.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.Impl.CarouselDaoImpl;
import cn.lxy.po.Carousel;

@Transactional
@Service(value="carouselServc")
public class CarouselServc extends CommonSevc<Carousel, CarouselDaoImpl> {

	@Override
	public void save(Carousel arg) {
		daoImpl.save(arg);		
	}

	@Override
	public Carousel find(String arg) throws Exception {
		return (Carousel) getEntity.getEntity("Carousel", "id", arg, Carousel.class);
	}

	@Override
	public List<Carousel> findAll(String arg) {
		return daoImpl.findAll();
	}

	@Override
	public void delete(Carousel arg) {
		daoImpl.delete(arg);		
	}

}
