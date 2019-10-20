package com.keepzzz.film.vo;


import javax.validation.constraints.*;

public class CommentVO {

    @NotNull
    private Long userId;
    @NotNull
    private Long filmId;
    @NotBlank(message = "评论内容不能为空")
    private String comments;
    @NotNull(message = "评分不能为空")
    @Min(value = 0)
    @Max(value = 10)
    private Integer score;

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
