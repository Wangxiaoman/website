/**
 * @FileName: IndexController.java
 * @Package com.cta.controller
 * @Description: TODO
 * @author chenwenpeng
 * @date 2013-5-18 下午04:07:12
 * @version V1.0
 */
package com.threenoodles.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.threenoodles.domain.Plan;
import com.threenoodles.domain.PlanItem;
import com.threenoodles.service.PlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {

	public static Logger logger = Logger.getLogger(PlanController.class);
	
	@Resource
	private PlanService planService;

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String save(Model model){
    try {
      List<Plan> plans = planService.queryList();
      model.addAttribute("plans", plans);
    } catch (Exception e) {
      e.printStackTrace();
    }
		return "/plan";
	}
	
	@RequestMapping(value="/status",method=RequestMethod.GET)
	public String updateStatus(Model model,
	    @RequestParam(required=true,value="id") int id,
	    @RequestParam(required=true,value="status") int status
	    ){
	  try {
      planService.update(id, status);
    } catch (Exception e) {
      e.printStackTrace();
    }
		return "redirect:/plan/list";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,
	    @RequestParam(required=true,value="name") String name,
	    @RequestParam(required=true,value="content") String content,
	    @RequestParam(required=true,value="money",defaultValue="0") int money,
	    @RequestParam(required=true,value="userName",defaultValue="1") int userName,
	    @RequestParam(required=true,value="beginTime",defaultValue="") String beginTime,
	    @RequestParam(required=true,value="endTime",defaultValue="") String endTime
	    ){
	  
	  Plan plan = new Plan();
	  plan.setName(name);
	  plan.setContent(content);
	  plan.setMoney(money);
	  plan.setUserName(userName);
	  plan.setBeginTime(beginTime);
	  plan.setEndTime(endTime);
	  
	  try {
      planService.insert(plan);
    } catch (Exception e) {
      e.printStackTrace();
    }
	  
		return "redirect:/plan/list";
	}
	
	@RequestMapping(value="/item",method=RequestMethod.POST)
  public String saveItem(Model model,
      @RequestParam(required=true,value="name") String name,
      @RequestParam(required=true,value="money",defaultValue="0") int money,
      @RequestParam(required=true,value="planId") int planId,
      @RequestParam(required=false,value="content",defaultValue="") String content
      ){
    
    PlanItem planItem = new PlanItem();
    planItem.setName(name);
    planItem.setMoney(money);
    planItem.setPlanId(planId);
    planItem.setContent(content);
    try {
      planService.insertItem(planItem);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:/plan/list";
  }
	
	@RequestMapping(value="/toSave",method=RequestMethod.GET)
  public String toSave(Model model){
	  return "/plan_save";
	}
	
	@RequestMapping(value="/toItemSave",method=RequestMethod.GET)
  public String toItemSave(Model model,
      @RequestParam(required=true,value="planId") String planId
      ){
	  model.addAttribute("planId", planId);
    return "/item_save";
  }

}
