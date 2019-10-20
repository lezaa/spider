package com.keepzzz.film.provider;

import com.keepzzz.film.domain.OrderDetail;
import org.apache.ibatis.jdbc.SQL;

public class OrderDetailProvider {
    public String insertOrderDetail(final OrderDetail orderDetail) {
        return new SQL() {{
            INSERT_INTO("order_detail");
            if (orderDetail.getOrderId()!= null) {
                VALUES("order_id", "#{orderId}");
            }
            if (orderDetail.getFilmId()!= null) {
                VALUES("film_id", "#{filmId}");
            }
            if (orderDetail.getSnackId()!= null) {
                VALUES("snack_id", "#{snackId}");
            }
            if (orderDetail.getSeatId()!= null) {
                VALUES("seat_id", "#{seatId}");
            }
            if (orderDetail.getFilmCount()!= null) {
                VALUES("film_count", "#{filmCount}");
            }
            if (orderDetail.getSnackNum()!= null) {
                VALUES("snack_num", "#{snackNum}");
            }
            if (orderDetail.getOrderPrice()!= null) {
                VALUES("order_price", "#{orderPrice}");
            }


        }}.toString();
    }
    public String updateOrderDetail(final OrderDetail orderDetail) {
        return new SQL() {{
            UPDATE("order_detail");
            if (orderDetail.getOrderId()!= null) {
                SET("order_id = #{orderId}");
            }
            if (orderDetail.getFilmId()!= null) {
                SET("film_id = #{filmId}");
            }
            if (orderDetail.getSnackId()!= null) {
                SET("snack_id = #{snackId}");
            }
            if (orderDetail.getSeatId()!= null) {
                SET("seat_id = #{seatId}");
            }
            if (orderDetail.getFilmCount()!= null) {
                SET("film_count = #{filmCount}");
            }
            if (orderDetail.getSnackNum()!= null) {
                SET("snack_num = #{snackNum}");
            }
            if (orderDetail.getOrderPrice()!= null) {
                SET("order_price = #{orderPrice}");
            }
            WHERE("id = #{id}");

        }}.toString();
    }
}
