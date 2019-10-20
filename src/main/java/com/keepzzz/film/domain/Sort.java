package com.keepzzz.film.domain;

/**
 * 影片分类
 */
public class Sort {

  private Long id;
  private String sortName;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSortName() {
    return sortName;
  }

  public void setSortName(String sortName) {
    this.sortName = sortName;
  }
}
