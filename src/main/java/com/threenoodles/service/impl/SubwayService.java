package com.threenoodles.service.impl;

import java.util.List;

import com.threenoodles.domain.Subway;

public interface SubwayService {
	int save(String name);
	List<Subway> getList();
	int clear();
}
