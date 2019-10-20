package com.keepzzz.film.domain;

/**
 * 电影评论
 */

import java.util.Date;

public class Comment {

  private Long id;
  private Long userId;
  private Long filmId;
  private Date createTime;
  private String comments;
  private Integer score;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getFilmId() {
    return filmId;
  }

  public void setFilmId(Long filmId) {
    this.filmId = filmId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public Integer getScore() {
    return score;
  }

  public void setScore(Integer score) {
    this.score = score;
  }
}
