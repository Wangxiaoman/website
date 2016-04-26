package com.threenoodles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qlm")
public class QLMTestController {
  
  @RequestMapping("test")
  public String toTestHtml(){
    return "/qlmtest";
  }
}
