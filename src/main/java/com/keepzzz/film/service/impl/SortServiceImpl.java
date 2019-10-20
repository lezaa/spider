package com.keepzzz.film.service.impl;

import com.keepzzz.film.domain.Sort;
import com.keepzzz.film.mapper.SortMapper;
import com.keepzzz.film.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private SortMapper sortMapper;

    @Override
    public List<Sort> sortList() {
        return sortMapper.getSorts();
    }

    @Override
    public Sort SortInfo(long sortId) {
        return sortMapper.getSort(sortId);
    }
}
