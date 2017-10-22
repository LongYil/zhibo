package cn.lxy.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import cn.lxy.dao.CarouselDao;
import cn.lxy.dao.Impl.CarouselDaoImpl;

@Transactional
@Scope(value="carouselServc")
public class CarouselServc extends CommonSevc<CarouselDao, CarouselDaoImpl> {

	@Override
	public void save(CarouselDao arg) {
		//
		
	}

	@Override
	public CarouselDao find(String arg) throws Exception {
		//
		return null;
	}

	@Override
	public List<CarouselDao> findAll(String arg) {
		//
		return null;
	}

	@Override
	public void delete(CarouselDao arg) {
		//
		
	}

}
