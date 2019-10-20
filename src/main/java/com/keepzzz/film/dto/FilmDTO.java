package com.keepzzz.film.dto;

import java.util.Date;

public class FilmDTO {

    /**
     * 所在分类
     */
    private String sortName;
    /**
     * 所在地区
     */
    private String zone;
    private String filmName;
    private Long filmTime;
    private String filmDirector;
    private String filmPlayers;
    private String filmIntro;
    private String filmLanguage;

    /**
     * 上映时间
     */
    private Date playTime;
    private String filmPhoto;

    private double score;

    public String getSortName() {
        return sortName;
    }

    public FilmDTO(){}

    public FilmDTO(String sortName, String zone, String filmName, Long filmTime,
                   String filmDirector, String filmPlayers, String filmIntro,
                   String filmLanguage, Date playTime, String filmPhoto, double score) {
        this.sortName = sortName;
        this.zone = zone;
        this.filmName = filmName;
        this.filmTime = filmTime;
        this.filmDirector = filmDirector;
        this.filmPlayers = filmPlayers;
        this.filmIntro = filmIntro;
        this.filmLanguage = filmLanguage;
        this.playTime = playTime;
        this.filmPhoto = filmPhoto;
        this.score = score;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
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

    public void setFilmLanguage(String filmLanguage) {
        this.filmLanguage = filmLanguage;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
