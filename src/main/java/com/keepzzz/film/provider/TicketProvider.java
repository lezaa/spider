package com.keepzzz.film.provider;


import com.keepzzz.film.domain.Ticket;
import org.apache.ibatis.jdbc.SQL;

public class TicketProvider {
    public String insertTicket(final Ticket ticket) {
        return new SQL() {{
            INSERT_INTO("ticket");
            if (ticket.getFilmId() != null) {
                VALUES("film_id", "#{filmId}");
            }
            if (ticket.getHallId() != null) {
                VALUES("hall_id", "#{hallId}");
            }
            if (ticket.getCreateTime() != null) {
                VALUES("create_time", "#{createTime}");
            }
            if (ticket.getSeatId() != null) {
                VALUES("seat_id", "#{seatId}");
            }
            if (ticket.getTicketPrice() != null) {
                VALUES("ticket_price", "#{ticketPrice}");
            }
            if (ticket.getOrderId() != null) {
                VALUES("order_id", "#{orderId}");
            }

        }}.toString();
    }

        public String updateTicket(final Ticket ticket) {
            return new SQL() {{
                UPDATE("ticket");
                if (ticket.getFilmId() != null) {
                    SET("film_id = #{filmId}");
                }
                if (ticket.getHallId() != null) {
                    SET("hall_id = #{hallId}");
                }
                if (ticket.getCreateTime() != null) {
                    SET("create_time = #{createTime}");
                }
                if (ticket.getSeatId() != null) {
                    SET("seat_id = #{seatId}");
                }
                if (ticket.getTicketPrice() != null) {
                    SET("ticket_price = #{ticketPrice}");
                }
                if (ticket.getOrderId() != null) {
                    SET("order_id = #{orderId}");
                }
                WHERE("id = #{id}");
            }}.toString();




}}