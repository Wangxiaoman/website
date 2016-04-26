package com.threenoodles.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
  
  @Select("select count(1) from user where name=#{name}")
  int exist(@Param("name")String name);
  
  @Insert("insert into user(name) values(#{name})")
  int insert(@Param("name")String name);
}
