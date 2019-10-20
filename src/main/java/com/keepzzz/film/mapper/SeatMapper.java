package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.Seat;
import com.keepzzz.film.provider.SeatProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface SeatMapper {
    /**
     * 查询所有座位
     * @return
     */
    @Select("select * from seat")
    List<Seat> getSeats();

    /**
     * 根据id查询座位
     * @param id
     * @return
     */
    @Select("select * from seat where id = #{id}")
    Seat getSeat(long id);

    /**
     * 添加座位
     * @return
     */
    @InsertProvider(type = SeatProvider.class,method = "insertSeat")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insert(Seat seat);

    /**
     * 修改座位
     * @param seat
     * @return
     */
    @UpdateProvider(type = SeatProvider.class,method = "updateSeat")
    int update(Seat seat);
}
