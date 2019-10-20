package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.Sort;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SortMapper {

    @Select("select * from sort")
    List<Sort> getSorts();

    @Select("select * from sort where id = #{sortId}")
    Sort getSort(long sortId);
}
