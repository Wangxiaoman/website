package com.threenoodles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/train")
public class QLMTestController {
  
  @RequestMapping(value = "/plus", produces = { "text/plain;charset=UTF-8" })
  @ResponseBody
  public String index(
      @RequestParam(required=true,value="a") int a,
      @RequestParam(required=true,value="b") int b
      ) {
    return String.valueOf(a*b);
  }
}
