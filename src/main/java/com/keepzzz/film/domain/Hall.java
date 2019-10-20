package com.keepzzz.film.domain;

/**
 * 影厅
 */
public class Hall {

  private Long id;
  private String hallName;
  private Long hallNum;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getHallName() {
    return hallName;
  }

  public void setHallName(String hallName) {
    this.hallName = hallName;
  }

  public Long getHallNum() {
    return hallNum;
  }

  public void setHallNum(Long hallNum) {
    this.hallNum = hallNum;
  }
}
