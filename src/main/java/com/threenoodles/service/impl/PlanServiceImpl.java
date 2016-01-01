package com.threenoodles.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.threenoodles.dao.PlanDao;
import com.threenoodles.domain.Plan;
import com.threenoodles.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
    @Resource
    private PlanDao planDao;

    @Override
    public int insert(Plan plan) throws Exception {
    	try{
        	return planDao.insert(plan);
        }catch(Exception ex){
        	throw ex;
        }
    }

    @Override
    public int update(int id,int status) throws Exception {
    	try{
        	return planDao.updateStatus(id, status);
        }catch(Exception ex){
        	throw ex;
        }
    }

    
    @Override
    public List<Plan> queryList(int parentId) throws Exception {
    	try{
			List<Plan> result = planDao.queryList(parentId);
			return result ;
        }catch(Exception ex){
	    	throw ex;
	    }
    }

    @Override
    public Plan queryById(int id) throws Exception {
        try{	
        	return planDao.getById(id);
        }catch(Exception ex){
	    	throw ex;
	    }
    }

}
