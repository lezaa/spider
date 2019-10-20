package com.keepzzz.film.service;

import com.keepzzz.film.domain.Film;
import com.keepzzz.film.dto.FilmDTO;

import java.util.List;

public interface FilmService {

    List<Film> getAllFilms();

    boolean addFilm(Film film);

    Film getFilmInfo(long FilmId);

    List<Film> stateFilm(long state);

    List<Film> sortFilm(long sortId);

    List<Film> areaFilm(long areaId);

    boolean updateFilm(Film film);

    boolean deleteFilm(long filmId);

    boolean deleteBatchFIlms(Long[] ids);

}
