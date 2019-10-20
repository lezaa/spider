package com.keepzzz.film.service;

import com.keepzzz.film.domain.Sort;

import java.util.List;

public interface SortService {

    List<Sort> sortList();

    Sort SortInfo(long sortId);
}
