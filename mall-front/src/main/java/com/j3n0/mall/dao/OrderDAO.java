package com.j3n0.mall.dao;

import com.j3n0.mall.model.ForeOrder;
import com.j3n0.mall.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Long> {

    @Query("SELECT " +
            "NEW com.j3n0.mall.model.ForeOrder(" +
            "o.id, o.uid, o.status, o.deleteStatus, o.totalAmount, o.createDate" +
            ") " +
            "FROM " +
            "Order o " +
            "WHERE o.uid = :uid")
    List<ForeOrder> listForeOrder(@Param("uid") Long uid);
}
