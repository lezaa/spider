package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.Hall;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallMapper {
    /**
     * 查询所有影厅
     * @return
     */
    @Select("select * from hall")
    List<Hall> getHalls();

    /**
     * 根据id查询影厅
     */
    @Select("select * from hall where id = #{id}")
    Hall getHallById(long id);

    /**
     * 根据名字查询影厅
     */
    @Select("select * from hall where hall_name = #{hallName}")
    Hall getHallByName(String hallName);
}
