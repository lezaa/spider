package com.keepzzz.film.controller.front;


import com.keepzzz.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/pub")
public class PublicController {

    @Autowired
    private FilmService filmService;









}

