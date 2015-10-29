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

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.threenoodles.domain.Subway;
import com.threenoodles.service.impl.SubwayService;

@Controller
public class SubwayController {

	public static Logger logger = Logger.getLogger(SubwayController.class);
	
	@Resource
	private SubwayService subwayService;

	@RequestMapping("/show")
	public String toSite(Model model){
		List<Subway> data = subwayService.getList();
		model.addAttribute("data", data);
		return "site";
	}
	
	@RequestMapping(value="/subway",method=RequestMethod.POST)
	public String save(Model model,
			@RequestParam(required=true,value="name") String name){
		if(StringUtils.isNotBlank(name)){
			subwayService.save(name);
		}
		return "redirect:/show";
	}
	

}
