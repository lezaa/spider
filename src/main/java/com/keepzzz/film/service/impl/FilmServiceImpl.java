package com.keepzzz.film.service.impl;

import com.keepzzz.film.domain.Film;
import com.keepzzz.film.dto.FilmDTO;
import com.keepzzz.film.mapper.FilmMapper;
import com.keepzzz.film.service.FilmService;
import com.keepzzz.film.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private static final Logger log = LoggerFactory.getLogger(FilmServiceImpl.class);

    private static final String ALL_FILMS = "allfilms";

    private static final String FILM = "film:";

    @Autowired
    private FilmMapper filmMapper;

    @Autowired
    private RedisService redisService;


    /**
     * 从缓冲中获取数据
     * @return
     */
    @Override
    public List<Film> getAllFilms() {
        List<Film> films = (List<Film>) redisService.get(ALL_FILMS);
        if(films != null)
        {
            log.info("从缓存中获取数据");
            return films;
        }else {
            List<Film> DBfilms = filmMapper.getAll();
            redisService.set(ALL_FILMS,DBfilms);
            log.info("从数据库获取数据");
            return DBfilms;
        }

    }

    @Override
    public boolean addFilm(Film film) {
        int flag = filmMapper.insert(film);
        redisService.set(FILM+film.getId(),film);
        return flag > 0;
    }

    @Override
    public Film getFilmInfo(long filmId) {
      Film film = (Film) redisService.get(FILM+filmId);
      if(film != null){
          log.info("从缓存中获取电影信息");
          return film;
      }
      log.info("从数据库中获取电影信息");
      return filmMapper.getFilmById(filmId);
    }

    @Override
    public List<Film> stateFilm(long state) {
        return filmMapper.getFilmsByState(state);
    }

    @Override
    public List<Film> sortFilm(long sortId) {
        return filmMapper.getFilmsBySort(sortId);

    }

    @Override
    public List<Film> areaFilm(long areaId) {
        return filmMapper.getFilmsByArea(areaId);
    }

    @Override
    public boolean updateFilm(Film film) {
        return filmMapper.update(film) > 0;
    }

    @Override
    public boolean deleteFilm(long filmId) {
        return filmMapper.delete(filmId) > 0;

    }

    @Override
    public boolean deleteBatchFIlms(Long[] ids) {
        List<Long> fids = new ArrayList<>(Arrays.asList(ids));
        return filmMapper.deleteBatch(fids) > 0;
    }


}
