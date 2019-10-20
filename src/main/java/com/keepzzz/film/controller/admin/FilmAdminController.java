package com.keepzzz.film.controller.admin;

import com.keepzzz.film.base.ApiResponse;
import com.keepzzz.film.domain.Film;
import com.keepzzz.film.enums.Status;
import com.keepzzz.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 管理端 电影操作相关接口
 *
 */

@RestController
@RequestMapping("/admin/api/v1/film")
public class FilmAdminController {

    @Autowired
    private FilmService filmService;


    /**
     * 更新电影信息
     * @param film
     * @param bindingResult
     * @return
     */
    @PostMapping("/update")
    public ApiResponse updateFilmInfo(@Validated @RequestBody Film film, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ApiResponse.ofStatus(Status.NOT_VALID_PARAM);
        }
        boolean flag = filmService.updateFilm(film);
        if(flag){
            return ApiResponse.ofSuccess();
        }
        return ApiResponse.ofStatus(Status.BAD_REQUEST);
    }

    /**
     * 删除电影
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ApiResponse delFilm(@PathVariable("id") long id){
        boolean flag = filmService.deleteFilm(id);
        if(flag){
            return ApiResponse.ofSuccess();
        }
        return ApiResponse.ofStatus(Status.BAD_REQUEST);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/delAll")
    public ApiResponse delFilm(Long[] ids){
        boolean flag = filmService.deleteBatchFIlms(ids);
        if(flag){
            return ApiResponse.ofSuccess();
        }
        return ApiResponse.ofStatus(Status.BAD_REQUEST);
    }

}
