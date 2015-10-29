package com.threenoodles.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.threenoodles.domain.Subway;

@Repository
public interface SubwayDao {
    
	@Insert("insert into subway(name) values(#{name})")
	int insert(String name);
	
	@Select("select * from subway")
	List<Subway> getList();

}
