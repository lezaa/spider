package com.keepzzz.film.controller.front;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @GetMapping("/add")
    public void saveOrder(@RequestParam(value = "filmId",required = true)int videoId) throws Exception{

    }


}
