package com.keepzzz.film.provider;

import com.keepzzz.film.domain.Area;
import org.apache.ibatis.jdbc.SQL;

public class AreaProvider {

    public String insertArea(final Area area){
        return new SQL(){{
            INSERT_INTO("area");
            if (area.getZone() != null){
                VALUES("zone","#{zone}");
            }
        }}.toString();
    }
}
