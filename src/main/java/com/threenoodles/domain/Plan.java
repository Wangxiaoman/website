package com.threenoodles.domain;

import java.util.Date;

public class Plan {

  private int id;
  // 计划名称
  private String name;
  // 计划描述
  private String content;
  // 创建时间
  private Date createTime;
  // 开始时间
  private String beginTime;
  // 完成时间
  private String endTime;
  // 计划钱数
  private int money;
  // 0-未开始、1-已经开始、2-完成
  private int status;
  // 父节点，如果为0那么为根级任务
  private int parentId;
  private int userName;

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

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public String getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(String beginTime) {
    this.beginTime = beginTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public int getMoney() {
    return money;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getStatus() {
    return status;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  public int getParentId() {
    return parentId;
  }

  public int getUserName() {
    return userName;
  }

  public void setUserName(int userName) {
    this.userName = userName;
  }
}