package cn.lxy.dao.Impl;

import org.springframework.stereotype.Component;

import cn.lxy.dao.DiscussDao;
import cn.lxy.po.Discuss;

@Component(value="discussDaoImpl")
public class DiscussDaoImpl extends CommonDaoImpl<Discuss> implements DiscussDao {

}
