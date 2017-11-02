package cn.lxy.dao.Impl;

import org.springframework.stereotype.Component;

import cn.lxy.dao.CarouselDao;
import cn.lxy.po.Carousel;

@Component(value="courseDaoImpl")
public class CourseDaoImpl extends CommonDaoImpl<Carousel> implements CarouselDao {
	
}
