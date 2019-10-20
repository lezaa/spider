package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    /**
     * 查询所有票房
     * @return
     */
    @Select("select * from book")
    List<Book> getBooks();

    /**
     * 根据id查询票房
     * @param id
     * @return
     */
    @Select("select * from book where id = #{id}")
    Book getBook(long id);
}
