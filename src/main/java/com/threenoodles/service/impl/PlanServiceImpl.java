package com.threenoodles.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.threenoodles.dao.PlanDao;
import com.threenoodles.domain.Plan;
import com.threenoodles.domain.PlanItem;
import com.threenoodles.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
  @Resource
  private PlanDao planDao;

  @Override
  public int insert(Plan plan) throws Exception {
    try {
      return planDao.insert(plan);
    } catch (Exception ex) {
      throw ex;
    }
  }

  @Override
  public int update(int id, int status) throws Exception {
    try {
      return planDao.updateStatus(id, status);
    } catch (Exception ex) {
      throw ex;
    }
  }

  @Override
  public void queryList(Model model) throws Exception {
    try {
      int allMoney = 0;
      int allCurrentMoney = 0;
      List<Plan> result = planDao.queryList();
      for (Plan plan : result) {
        int currentMoney = 0;
        List<PlanItem> items = planDao.queryItemList(plan.getId());
        for (PlanItem pi : items) {
          currentMoney = currentMoney + pi.getMoney();
        }
        plan.setCurrentMoney(currentMoney);
        plan.setPlanItems(items);
        
        allMoney = allMoney + plan.getMoney();
        allCurrentMoney = allCurrentMoney + currentMoney;
      }
      
      model.addAttribute("plans", result);
      model.addAttribute("allMoney",allMoney);
      model.addAttribute("allCurrentMoney",allCurrentMoney);
    } catch (Exception ex) {
      throw ex;
    }
  }

  @Override
  public Plan queryById(int id) throws Exception {
    try {
      return planDao.getById(id);
    } catch (Exception ex) {
      throw ex;
    }
  }

  @Override
  public int insertItem(PlanItem planItem) throws Exception {
    try {
      return planDao.insertItem(planItem);
    } catch (Exception ex) {
      throw ex;
    }
  }

}
