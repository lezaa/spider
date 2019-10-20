package com.keepzzz.film.domain;

/**
 * 零食
 */
public class Snack {

  private Long id;
  private String snackName;
  private Double snackPrice;
  private Long snackStore;
  private String snackPicture;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSnackName() {
    return snackName;
  }

  public void setSnackName(String snackName) {
    this.snackName = snackName;
  }

  public Double getSnackPrice() {
    return snackPrice;
  }

  public void setSnackPrice(Double snackPrice) {
    this.snackPrice = snackPrice;
  }

  public Long getSnackStore() {
    return snackStore;
  }

  public void setSnackStore(Long snackStore) {
    this.snackStore = snackStore;
  }

  public String getSnackPicture() {
    return snackPicture;
  }

  public void setSnackPicture(String snackPicture) {
    this.snackPicture = snackPicture;
  }
}
