package com.keepzzz.film.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.keepzzz.film.base.ApiResponse;
import com.keepzzz.film.domain.Film;
import com.keepzzz.film.dto.FilmDTO;
import com.keepzzz.film.enums.Status;
import com.keepzzz.film.service.AreaService;
import com.keepzzz.film.service.FilmService;
import com.keepzzz.film.service.SortService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.keepzzz.film.enums.Status.NOT_VALID_PARAM;

@RestController
@RequestMapping("/api/v1/film")
public class FilmController {

    @Autowired
    private AreaService areaService;

    @Autowired
    private FilmService filmService;

    @Autowired
    private SortService sortService;



    /**
     * 电影列表接口
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/films")
    public ApiResponse filmList(@RequestParam(value = "page",defaultValue = "1") int page,
                                @RequestParam(value = "size",defaultValue = "8") int size){

        List<Film> allFilms = filmService.getAllFilms();
        Map<String, Object> data = page(page, size, allFilms);
        return ApiResponse.ofSuccess(data);
    }



    /**
     * 获取指定的电影信息
     * @param filmId
     * @return
     */
    @GetMapping("/{id}")
    public ApiResponse filmInfo(@PathVariable("id") long filmId){

        Film film = filmService.getFilmInfo(filmId);
        FilmDTO filmDTO = new FilmDTO();
        if(film != null){
            //TODO 电影评分
            BeanUtils.copyProperties(film,filmDTO);
            filmDTO.setZone(areaService.getArea(film.getAreaId()).getZone());
            filmDTO.setSortName(sortService.SortInfo(film.getSortId()).getSortName());
            return ApiResponse.ofSuccess(filmDTO);
        }
        return ApiResponse.ofStatus(NOT_VALID_PARAM);
    }


    /**
     * 按照状态获取电影列表
     * @param state
     * @return
     */
    @GetMapping("/state/{state}")
    public ApiResponse filmState(@PathVariable("state") long state){
        List<Film> films = filmService.stateFilm(state);
        if(films != null){
            List<FilmDTO> filmDTOS = changeFilmDto(films);
            Map<String, Object> page = page(1, 8, filmDTOS);
            return ApiResponse.ofSuccess(page);
        }
        return ApiResponse.ofStatus(NOT_VALID_PARAM);
    }

    /**
     * 按照类别获取电影列表
     * @param sortId
     * @return
     */
    @GetMapping("/sort/{id}")
    public ApiResponse sortFilms(@PathVariable("id") long sortId){
        List<Film> films = filmService.sortFilm(sortId);
        if(films != null){
            List<FilmDTO> filmDTOS = changeFilmDto(films);
            Map<String, Object> page = page(1, 8, filmDTOS);
            return ApiResponse.ofSuccess(page);
        }
        return ApiResponse.ofStatus(Status.BAD_REQUEST);
    }


    /**
     * 按照区域获取电影列表
     * @param areaId
     * @return
     */
    @GetMapping("/area/{id}")
    public ApiResponse areaFilms(@PathVariable("id") long areaId){

        List<Film> films = filmService.areaFilm(areaId);
        if(films != null){
            List<FilmDTO> filmDTOS = changeFilmDto(films);
            Map<String, Object> page = page(1, 8, filmDTOS);
            return ApiResponse.ofSuccess(page);
        }
        return ApiResponse.ofStatus(Status.BAD_REQUEST);
    }



    private static<T> Map<String,Object> page(int page, int size, List<T> ts){
        PageHelper.startPage(page,size);
        PageInfo<T> pageInfo = new PageInfo<>(ts);
        Map<String,Object> data = new HashMap<>();
        data.put("totalPage",pageInfo.getPages());
        data.put("totalSize",pageInfo.getTotal());
        data.put("currentPage",page);
        data.put("data",pageInfo.getList());
        return data;
    }


    private  List<FilmDTO> changeFilmDto(List<Film> films){
        List<FilmDTO> filmDTOS = films.stream().map(e -> new FilmDTO(
                sortService.SortInfo(e.getSortId()).getSortName(),
                areaService.getArea(e.getAreaId()).getZone(),
                e.getFilmName(),e.getFilmTime(),e.getFilmDirector(),e.getFilmPlayers(),e.getFilmIntro(),
                e.getFilmLanguage(),e.getPlayTime(),e.getFilmPhoto(),e.getScore()
        )).collect(Collectors.toList());
        return filmDTOS;
    }
}



