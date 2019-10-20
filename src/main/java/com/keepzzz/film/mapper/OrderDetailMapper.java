package com.keepzzz.film.mapper;

import com.keepzzz.film.domain.OrderDetail;
import com.keepzzz.film.provider.OrderDetailProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailMapper {
    /**
     * 查询所有订单详情
     * @return
     */
    @Select("select * from order_detail")
    List<OrderDetail> getOrderDetails();

    /**
     * 查询单个订单详情
     * @param id
     * @return
     */
    @Select("select * from order_detail where id = #{id}")
    OrderDetail getOrderDetail(long id);

    /**
     * 添加订单详情
     * @param orderDetail
     * @return
     */
    @InsertProvider(type = OrderDetailProvider.class,method = "insertOrderDetail")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    int insert(OrderDetail orderDetail);

    /**
     * 修改订单详情
     * @param orderDetail
     * @return
     */
    @UpdateProvider(type = OrderDetailProvider.class,method = "updateOrderDetail")
    int update(OrderDetail orderDetail);
}
