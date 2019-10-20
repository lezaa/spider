package com.keepzzz.film.mapper;


import com.keepzzz.film.domain.Ticket;
import com.keepzzz.film.provider.TicketProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketMapper {
    /**
     * 查询所有电影票
     * @return
     */
    @Select("select * from ticket")
    List<Ticket> getTickets();

    /**
     * 查询单个电影票
     * @return
     */
    @Select("select * from ticket where id = #{id}")
    Ticket getTicket(long id);

    /**
     * 添加电影票
     * @param ticket
     * @return
     */
    @InsertProvider(type = TicketProvider.class,method = "insertTicket")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insert(Ticket ticket);

    /**
     * 更新电影票
     */
    @UpdateProvider(type = TicketProvider.class,method = "updateTicket")
    int update(Ticket ticket);
}
