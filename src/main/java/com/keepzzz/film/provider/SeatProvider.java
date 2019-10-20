package com.keepzzz.film.provider;

import com.keepzzz.film.domain.Seat;
import org.apache.ibatis.jdbc.SQL;

public class SeatProvider {
    public String insertSeat(final Seat seat) {
        return new SQL() {{
            INSERT_INTO("seat");
            if (seat.getHallId()!= null) {
                VALUES("hall_id", "#{hallId}");
            }
            if (seat.getRow()!= null) {
                VALUES("row", "#{row}");
            }
            if (seat.getNum()!= null) {
                VALUES("num", "#{num}");
            }
            if(seat.getState() != null){
                VALUES("state", "#{state}");
            }
        }}.toString();
    }


    public String updateSeat(final Seat seat) {
        return new SQL() {{
            UPDATE("seat");
            if (seat.getHallId()!= null) {
                SET("hall_id = #{hallId}");
            }
            if (seat.getRow()!= null) {
                SET("row = #{row}");
            }
            if (seat.getNum()!= null) {
                SET("num = #{num}");
            }
            if(seat.getState()!= null){
                SET("state = #{state}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }
}
