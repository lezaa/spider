package com.keepzzz.film.service;

import com.keepzzz.film.domain.Comment;
import com.keepzzz.film.dto.CommentDTO;
import com.keepzzz.film.vo.CommentVO;

import java.util.List;

public interface CommentService {


    boolean publishComment(CommentVO commentVO);

    List<CommentDTO> filmComments(long filmId);

    List<CommentDTO> userComments(long userId);

    boolean deleteComments(long id);

    boolean deleteBatchComment(Long[] ids);
}
