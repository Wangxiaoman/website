package com.threenoodles.service;

import java.util.List;

import com.threenoodles.domain.Plan;
import com.threenoodles.domain.PlanItem;

public interface PlanService {
    /**
     * 插入
     *
     * @param entity 实体对象
     * @return 实体对象
     * @throws Exception 系统异常
     */
    public int insert(Plan plan) throws Exception;
    
    public int insertItem(PlanItem planItem) throws Exception;

    /**
     * 修改
     *
     * @param entity 实体对象
     * @return 更新记录数
     * @throws Exception 系统异常
     */
    public int update(int id,int status) throws Exception ;

    /**
     * 查询集合
     *
     * @param page 查询开始页数； pageSize 数量
     * @return 实体对象列表
     * @throws Exception 系统异常
     */
    public List<Plan> queryList() throws Exception;

    /**
     * 查询对象
     *
     * @param id 
     * @return 实体对象
     * @throws Exception 系统异常
     */
    public Plan queryById(int id) throws Exception;

}