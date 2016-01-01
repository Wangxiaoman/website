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
import com.threenoodles.service.PlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {

	public static Logger logger = Logger.getLogger(PlanController.class);
	
	@Resource
	private PlanService planService;

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String save(Model model,
			@RequestParam(required=false,value="parentId",defaultValue="0") int parentId){
    try {
      List<Plan> plans = planService.queryList(parentId);
      model.addAttribute("plans", plans);
      model.addAttribute("parentId", parentId);
    } catch (Exception e) {
      e.printStackTrace();
    }
		return "/plan";
	}
	
	@RequestMapping(value="/status",method=RequestMethod.GET)
	public String updateStatus(Model model,
	    @RequestParam(required=true,value="id") int id,
	    @RequestParam(required=true,value="status") int status,
	    @RequestParam(required=false,value="parentId",defaultValue="0") int parentId
	    ){
	  try {
      planService.update(id, status);
    } catch (Exception e) {
      e.printStackTrace();
    }
		return "redirect:/plan/list?parentId="+parentId;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(Model model,
	    @RequestParam(required=true,value="name") String name,
	    @RequestParam(required=true,value="content") String content,
	    @RequestParam(required=true,value="money",defaultValue="0") int money,
	    @RequestParam(required=true,value="parentId",defaultValue="0") int parentId,
	    @RequestParam(required=true,value="userName",defaultValue="1") int userName,
	    @RequestParam(required=true,value="beginTime",defaultValue="") String beginTime,
	    @RequestParam(required=true,value="endTime",defaultValue="") String endTime
	    ){
	  
	  Plan plan = new Plan();
	  plan.setName(name);
	  plan.setContent(content);
	  plan.setMoney(money);
	  plan.setParentId(parentId);
	  plan.setUserName(userName);
	  plan.setBeginTime(beginTime);
	  plan.setEndTime(endTime);
	  
	  try {
      planService.insert(plan);
    } catch (Exception e) {
      e.printStackTrace();
    }
	  
		return "redirect:/plan/list?parentId="+parentId;
	}
	
	@RequestMapping(value="/toSave",method=RequestMethod.GET)
  public String toSave(Model model,@RequestParam(required=false,value="parentId",defaultValue="0") int parentId){
	  model.addAttribute("parentId",parentId);
	  return "/plan_save";
	}

}
