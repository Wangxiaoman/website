package com.threenoodles.domain;

import java.util.Date;

public class PlanItem {

  private int id;
  // 详情描述
  private String name;
  // 花销
  private int money;

  private int planId;
  // 创建时间
  private Date createTime;

  private String content;

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public int getMoney() {
    return money;
  }

  public void setPlanId(int planId) {
    this.planId = planId;
  }

  public int getPlanId() {
    return planId;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}