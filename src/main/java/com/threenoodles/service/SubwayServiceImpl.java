package com.threenoodles.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threenoodles.dao.SubwayDao;
import com.threenoodles.domain.Subway;
import com.threenoodles.service.impl.SubwayService;

@Service
public class SubwayServiceImpl implements SubwayService {
	
	@Resource
	private SubwayDao subwayDao;

	@Override
	public int save(String name) {
		return subwayDao.insert(name);
	}

	@Override
	public List<Subway> getList() {
		return subwayDao.getList();
	}
}
