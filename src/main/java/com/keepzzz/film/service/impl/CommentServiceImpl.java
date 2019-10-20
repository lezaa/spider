package com.keepzzz.film.service.impl;

import com.keepzzz.film.domain.Comment;
import com.keepzzz.film.dto.CommentDTO;
import com.keepzzz.film.mapper.CommentMapper;
import com.keepzzz.film.mapper.UserMapper;
import com.keepzzz.film.service.CommentService;
import com.keepzzz.film.vo.CommentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public boolean publishComment(CommentVO commentVO) {
        //限制每人一条评论,防止刷分
        Map<String,Object> params = new HashMap<>();
        params.put("film_id",commentVO.getFilmId());
        params.put("user_id",commentVO.getUserId());
        Comment commentResult = commentMapper.getCommentByFilmIdAndUserId(params);
        if(null != commentResult) {
            Comment comment = new Comment();
            comment.setCreateTime(new Date());
            BeanUtils.copyProperties(commentVO, comment);
            return commentMapper.insert(comment) > 0;
        }
        return false;
    }

    @Override
    public List<CommentDTO> filmComments(long filmId) {

        List<Comment> comments = commentMapper.getFilmComments(filmId);
        List<CommentDTO> commentDTOS = getCommentDTOs(comments);
        return commentDTOS;
    }

    @Override
    public List<CommentDTO> userComments(long userId) {
        List<Comment> comments = commentMapper.getCommentsByUserId(userId);
        List<CommentDTO> commentDTOs = getCommentDTOs(comments);
        return commentDTOs;
    }


    @Override
    public boolean deleteComments(long id) {
        return commentMapper.delete(id) > 0;
    }

    @Override
    public boolean deleteBatchComment(Long[] ids) {
        List<Long> cids = new ArrayList<>(Arrays.asList(ids));
        return commentMapper.deleteBatch(cids) > 0;
    }



    private List<CommentDTO> getCommentDTOs(List<Comment> comments){

       return comments.stream().map(e -> {
                    return new CommentDTO(userMapper.getUser(e.getUserId()).getUsername(),
                            userMapper.getUser(e.getUserId()).getUserPhoto(),
                            e.getScore(), e.getComments(), e.getCreateTime());
                }
        ).collect(Collectors.toList());
    }

}
