package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.Orders;
import com.keepzzz.film.provider.OrdersProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    /**
     * 查询所有订单
     * @return
     */
    @Select("select * from orders")
    List<Orders> getOrders();

    /**
     * 根据订单id查询单个订单
     * @return
     */
    @Select("select * from orders where id = #{id}")
    Orders getOrderByOrderId(Long id);


    /**
     * 根据用户id查询单个订单
     * @return
     */
    @Select("select * from orders where user_id = #{userId}")
    Orders getOrderByUserId(Long userId);

    /**
     * 添加订单
     * @param orders
     * @return
     */
    @InsertProvider(type = OrdersProvider.class,method = "insertOrders")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insert(Orders orders);


    /**
     * 更新订单
     */
    @UpdateProvider(type = OrdersProvider.class,method = "updateOrders")
    int update(Orders orders);
}
