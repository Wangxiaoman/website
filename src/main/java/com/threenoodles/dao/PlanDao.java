package com.threenoodles.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.threenoodles.domain.Plan;
import com.threenoodles.domain.PlanItem;

@Repository
public interface PlanDao {

  @Insert("insert into plan (name,content,begin_time,end_time,money,user_name) values (#{name},#{content},#{beginTime},#{endTime},#{money},#{userName})")
  @Options(useGeneratedKeys = true)
  int insert(Plan plan);

  @Update(" update plan set status=#{status} where id=#{id}")
  int updateStatus(@Param("id") int id,@Param("status") int status);

  @Select("select id,name,content,create_time,begin_time,end_time,money,status,user_name from plan order by user_name,id desc ")
  List<Plan> queryList();

  @Select("select id,name,content,create_time,begin_time,end_time,money,status from plan where id=#{id}")
  Plan getById(@Param("id") int id);
  
  @Insert("insert into plan_item (name,plan_id,money,content) values (#{name},#{planId},#{money},#{content})")
  @Options(useGeneratedKeys = true)
  int insertItem(PlanItem planItem);

  @Select("select id,name,money,create_time,money,content from plan_item where plan_id=#{planId} order by id desc ")
  List<PlanItem> queryItemList(@Param("planId") int planId);
}
