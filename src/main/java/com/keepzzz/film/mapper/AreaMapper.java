package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.Area;
import com.keepzzz.film.provider.AreaProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaMapper {

    @Select("select * from area")
    List<Area> getAreas();


    @InsertProvider(type = AreaProvider.class,method = "insertArea")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insertArea(Area area);



    @Select("select * from area where id = #{id}")
    Area getArea(long id);

}
