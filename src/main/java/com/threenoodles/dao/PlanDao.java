package com.threenoodles.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.threenoodles.domain.Plan;

@Repository
public interface PlanDao {

  @Insert("insert into plan (name,content,begin_time,end_time,money,parent_id,user_name) values (#{name},#{content},#{beginTime},#{endTime},#{money},#{parentId},#{userName})")
  @Options(useGeneratedKeys = true)
  int insert(Plan plan);

  @Update(" update plan set status=#{status} where id=#{id}")
  int updateStatus(@Param("id") int id,@Param("status") int status);

  @Select("select id,name,content,create_time,begin_time,end_time,money,status,parent_id,user_name from plan where parent_id=#{parentId} order by user_name,id desc ")
  List<Plan> queryList(@Param("parentId") int parentId);

  @Select("select id,name,content,create_time,begin_time,end_time,money,status,parent_id from plan where id=#{id}")
  Plan getById(@Param("id") int id);

}
