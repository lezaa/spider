package com.keepzzz.film.service.impl;

import com.keepzzz.film.domain.Area;
import com.keepzzz.film.mapper.AreaMapper;
import com.keepzzz.film.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> getAllAreas() {
        return areaMapper.getAreas();
    }

    @Override
    public boolean addArea(Area area) {
        return areaMapper.insertArea(area) > 0;
    }

    @Override
    public Area getArea(long id) {
        return areaMapper.getArea(id);
    }


}
