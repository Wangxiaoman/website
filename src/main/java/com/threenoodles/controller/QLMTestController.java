package com.threenoodles.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.threenoodles.dao.UserDao;

@Controller
@RequestMapping("/train")
public class QLMTestController {
  
  @Resource
  private UserDao userDao;
  
  @RequestMapping(value = "/plus", produces = { "text/plain;charset=UTF-8" })
  @ResponseBody
  public String index(
      @RequestParam(required=true,value="a") int a,
      @RequestParam(required=true,value="b") int b
      ) {
    return String.valueOf(a*b);
  }
  
  @RequestMapping(value = "/register", produces = { "text/plain;charset=UTF-8" })
  @ResponseBody
  public String register(
      @RequestParam(required=true,value="registerusername") String username) {
    int userCount = userDao.exist(username);
    if(userCount == 0){
      userDao.insert(username);
      return "already used";
    }
    return "register success";
  }
  
}
