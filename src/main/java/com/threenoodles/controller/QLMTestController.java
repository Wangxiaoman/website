package com.threenoodles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/qlm")
public class QLMTestController {
  
  @RequestMapping(value = "/index", produces = { "text/plain;charset=UTF-8" })
  @ResponseBody
  public String index() {
    String name = new String("simmer");
    return name;
  }
}
