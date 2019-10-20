package com.keepzzz.film.domain;

/**
 * 票房
 */
public class Book {

  private Long id;
  private Long filmId;
  private Long filmCount;
  private Double totalPrice;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFilmId() {
    return filmId;
  }

  public void setFilmId(Long filmId) {
    this.filmId = filmId;
  }

  public Long getFilmCount() {
    return filmCount;
  }

  public void setFilmCount(Long filmCount) {
    this.filmCount = filmCount;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }
}
