package com.keepzzz.film.service;

import com.keepzzz.film.domain.Area;

import java.util.List;

public interface AreaService {

    List<Area> getAllAreas();

    boolean addArea(Area area);

    Area getArea(long id);
}
