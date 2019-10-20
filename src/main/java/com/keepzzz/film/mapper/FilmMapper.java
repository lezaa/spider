package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.Film;
import com.keepzzz.film.provider.FilmProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FilmMapper {


    @Select("select * from film")
    List<Film> getAll();


    @Select("select * from film where id = #{filmId}")
    Film getFilmById(long filmId);


    @Select("select * from film where statu = #{state}")
    List<Film> getFilmsByState(long state);

    @Select("select * from film where sort_id = #{sortId}")
    List<Film> getFilmsBySort(long sortId);

    @Select("select * from film where area_id = #{areaId}")
    List<Film> getFilmsByArea(long areaId);

    /**
     * 更新电影
     * @param film
     * @return
     */
    @UpdateProvider(type = FilmProvider.class ,method = "updateFilm")
    int update(Film film);


    /**
     * 新增电影
     * @param film
     * @return
     */
    @InsertProvider(type = FilmProvider.class,method = "insertFilm")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insert(Film film);


    /**
     * 删除电影
     * @param id
     * @return
     */
    @Delete("delete from film where id = #{id}")
    int delete(long id);


    @DeleteProvider(type = FilmProvider.class,method = "batchDelete")
    int deleteBatch(List<Long> ids);
}
