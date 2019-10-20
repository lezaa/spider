package com.keepzzz.film.domain;

/**
 * 订单详情
 */
public class OrderDetail {

  private Long id;
  private Long orderId;
  private Double filmId;
  private Double snackId;
  private Long seatId;
  private Long filmCount;
  private Long snackNum;
  private Double orderPrice;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Double getFilmId() {
    return filmId;
  }

  public void setFilmId(Double filmId) {
    this.filmId = filmId;
  }

  public Double getSnackId() {
    return snackId;
  }

  public void setSnackId(Double snackId) {
    this.snackId = snackId;
  }

  public Long getSeatId() {
    return seatId;
  }

  public void setSeatId(Long seatId) {
    this.seatId = seatId;
  }

  public Long getFilmCount() {
    return filmCount;
  }

  public void setFilmCount(Long filmCount) {
    this.filmCount = filmCount;
  }

  public Long getSnackNum() {
    return snackNum;
  }

  public void setSnackNum(Long snackNum) {
    this.snackNum = snackNum;
  }

  public Double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(Double orderPrice) {
    this.orderPrice = orderPrice;
  }
}
