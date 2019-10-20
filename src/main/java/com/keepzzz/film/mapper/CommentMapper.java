package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.Comment;
import com.keepzzz.film.provider.CommentProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentMapper {


    /**
     *
     * 查询所有评论
     * @return
     */
    @Select("select * from comment")
    List<Comment> getComments();


    /**
     * 根据id查询评论
     * @return
     */
    @Select("select * from comment where id = #{id}")
    List<Comment> getComment(long id);


    @Select("select * from comment where film_id = #{filmId}")
    List<Comment> getFilmComments(long filmId);

    @Select("select * from comment where user_id = #{userId}")
    List<Comment>  getCommentsByUserId(long userId);

    @Select("select * from comment where user_id = #{userId} and film_id = #{filmId}")
    Comment getCommentByFilmIdAndUserId(Map<String,Object> params);

    /**
     * 添加评论
     * @param comment
     * @return
     */
    @InsertProvider(type = CommentProvider.class,method = "insertComment")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insert(Comment comment);


    /**
     * 更新评论
     */
    @UpdateProvider(type = CommentProvider.class,method = "updateComment")
    int update(Comment comment);

    @Delete("delete from comment where id = #{id}")
    int delete(long id);

    @DeleteProvider(type = CommentProvider.class,method = "batchDelete")
    int deleteBatch(List<Long> ids);
}
