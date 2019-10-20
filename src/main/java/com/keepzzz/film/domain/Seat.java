package com.keepzzz.film.domain;

/**
 * 座位
 */
public class Seat {

  private Long id;
  private Long hallId;
  private Long row;
  private Long num;
  private String state;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getHallId() {
    return hallId;
  }

  public void setHallId(Long hallId) {
    this.hallId = hallId;
  }

  public Long getRow() {
    return row;
  }

  public void setRow(Long row) {
    this.row = row;
  }

  public Long getNum() {
    return num;
  }

  public void setNum(Long num) {
    this.num = num;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}
