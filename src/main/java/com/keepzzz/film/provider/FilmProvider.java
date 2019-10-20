package com.keepzzz.film.provider;

import com.keepzzz.film.domain.Film;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;


public class FilmProvider {

    public String insertFilm(final Film film){
        return new SQL(){{
            INSERT_INTO("film");
            if(film.getSortId() != null){
                VALUES("sort_id" ,"#{sortId}");
            }
            if (film.getFilmName() != null){
                VALUES("film_name", "#{filmName}");
            }
            if(film.getAreaId() != null){
                VALUES("area_id ","#{areaId}");
            }
            if(film.getFilmDirector() != null){
                VALUES("film_director", "#{filmDirector}");
            }
            if(film.getFilmIntro() != null){
                VALUES("film_intro", "#{filmIntro}");
            }
            if(film.getFilmPlayers() != null){
                VALUES("film_players","#{filmPlayers}");
            }
            if(film.getFilmPhoto() != null){
                VALUES("film_photo" , "#{filmPhoto}");
            }
            if (film.getFilmTime() != null) {
                VALUES("film_time" ,"#{filmTime}");
            }
            if(film.getPlayTime() != null){
                VALUES("play_time" ,"#{playTime}");
            }
            if(film.getFilmPrice() != null){
                VALUES("film_price" ,"#{filmPrice}");
            }
            if(film.getStatu() != null) {
                VALUES("statu" ,"#{statu} ");
            }
            if(film.getFilmLanguage() != null){
                VALUES("film_language", "#{filmLanguage}");
            }
        }}.toString();
    }


    public String updateFilm(final Film film){
        return new SQL(){{
            UPDATE("film");
            if(film.getSortId() != null){
                SET("sort_id = #{sortId}");
            }
            if (film.getFilmName() != null){
                SET("film_name = #{filmName}");
            }
            if(film.getAreaId() != null){
                SET("area_id = #{areaId}");
            }
            if(film.getFilmDirector() != null){
                SET("film_director = #{filmDirector}");
            }
            if(film.getFilmIntro() != null){
                SET("film_intro = #{filmIntro}");
            }
            if(film.getFilmPlayers() != null){
                SET("film_players = #{filmPlayers}");
            }
            if(film.getFilmPhoto() != null){
                SET("film_photo = #{filmPhoto}");
            }
            if (film.getFilmTime() != null) {
                SET("film_time = #{filmTime}");
            }
            if(film.getPlayTime() != null){
                SET("play_time = #{playTime}");
            }
            if(film.getFilmPrice() != null){
                SET("film_price = #{filmPrice}");
            }
            if(film.getStatu() != null) {
                SET("statu = #{statu} ");
            }
            if(film.getFilmLanguage() != null){
                SET("film_language = #{filmLanguage}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }


    public String batchDelete(Map map) {

        List<Integer> ids = (List<Integer>) map.get("list");
        StringBuilder sb = new StringBuilder();

        sb.append("DELETE FROM film WHERE id IN (");

        for (int i = 0; i < ids.size(); i++) {

            sb.append("'").append(ids.get(i)).append("'");

            if (i < ids.size() - 1)

                sb.append(",");

        }

        sb.append(")");

        return sb.toString();

    }
}
