package com.keepzzz.film.dto;

import java.util.Date;

public class CommentDTO {

    private String username;

    private String userPhoto;

    private Integer score;

    private String comment;

    private Date createTime;

    public CommentDTO(String username, String userPhoto, Integer score, String comment, Date createTime) {
        this.username = username;
        this.userPhoto = userPhoto;
        this.score = score;
        this.comment = comment;
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
