package com.keepzzz.film.provider;

import com.keepzzz.film.domain.Orders;
import org.apache.ibatis.jdbc.SQL;

public class OrdersProvider {
    public String insertOrders(final Orders orders) {
        return new SQL() {{
            INSERT_INTO("oders");
            if (orders.getUserId() != null) {
                VALUES("user_id", "#{userId}");
            }
            if (orders.getCreateTime() != null) {
                VALUES("create_time", "#{createTime}");
            }
            if (orders.getStatus() != null) {
                VALUES("status", "#{status}");
            }

        }}.toString();
    }


    public String updateOrders(final Orders orders) {
        return new SQL() {{
            UPDATE("Orders");
            if (orders.getUserId() != null) {
                SET("user_id = #{userId}");
            }
            if (orders.getCreateTime() != null) {
                SET("create_time = #{createTime}");
            }
            if (orders.getStatus() != null) {
                SET("status = #{status}");
            }
            WHERE("id = #{id}");
        }}.toString();

    }
}
