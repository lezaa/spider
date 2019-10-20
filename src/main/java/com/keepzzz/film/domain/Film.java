package com.keepzzz.film.domain;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 电影
 */

public class Film {

  @NotNull
  private Long id;
  /**
   * 所在分类
   */
  @NotNull
  private Long sortId;
  /**
   * 所在地区
   */
  @NotNull
  private Long areaId;
  @NotEmpty
  private String filmName;

  private Long filmTime;
  @NotEmpty
  private String filmDirector;
  @NotEmpty
  private String filmPlayers;
  @NotEmpty
  private String filmIntro;
  @NotEmpty
  private String filmLanguage;
  @NotNull
  private Double filmPrice;
  /**
   * 上映时间
   */
  private Date playTime;
  @NotEmpty
  private String filmPhoto;
  /**
   * 电影状态 1:正在上映  0:下架  2:即将上映
   */
  @NotNull
  private Long statu;
  @NotNull
  private Double score;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getSortId() {
    return sortId;
  }

  public void setSortId(Long sortId) {
    this.sortId = sortId;
  }

  public Long getAreaId() {
    return areaId;
  }

  public void setAreaId(Long areaId) {
    this.areaId = areaId;
  }

  public String getFilmName() {
    return filmName;
  }

  public void setFilmName(String filmName) {
    this.filmName = filmName;
  }

  public Long getFilmTime() {
    return filmTime;
  }

  public void setFilmTime(Long filmTime) {
    this.filmTime = filmTime;
  }

  public String getFilmDirector() {
    return filmDirector;
  }

  public void setFilmDirector(String filmDirector) {
    this.filmDirector = filmDirector;
  }

  public String getFilmPlayers() {
    return filmPlayers;
  }

  public void setFilmPlayers(String filmPlayers) {
    this.filmPlayers = filmPlayers;
  }

  public String getFilmIntro() {
    return filmIntro;
  }

  public void setFilmIntro(String filmIntro) {
    this.filmIntro = filmIntro;
  }

  public String getFilmLanguage() {
    return filmLanguage;
  }

  public void setFilmLanguage(String flimLanguage) {
    this.filmLanguage = flimLanguage;
  }

  public Double getFilmPrice() {
    return filmPrice;
  }

  public void setFilmPrice(Double filmPrice) {
    this.filmPrice = filmPrice;
  }

  public Date getPlayTime() {
    return playTime;
  }

  public void setPlayTime(Date playTime) {
    this.playTime = playTime;
  }

  public String getFilmPhoto() {
    return filmPhoto;
  }

  public void setFilmPhoto(String filmPhoto) {
    this.filmPhoto = filmPhoto;
  }

  public Long getStatu() {
    return statu;
  }

  public void setStatu(Long statu) {
    this.statu = statu;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }


  @Override
  public String toString() {
    return "Film{" +
            "id=" + id +
            ", sortId=" + sortId +
            ", areaId=" + areaId +
            ", filmName='" + filmName + '\'' +
            ", filmTime=" + filmTime +
            ", filmDirector='" + filmDirector + '\'' +
            ", filmPlayers='" + filmPlayers + '\'' +
            ", filmIntro='" + filmIntro + '\'' +
            ", filmLanguage='" + filmLanguage + '\'' +
            ", filmPrice=" + filmPrice +
            ", playTime=" + playTime +
            ", filmPhoto='" + filmPhoto + '\'' +
            ", statu=" + statu +
            ", score=" + score +
            '}';
  }
}
