package com.ejemplonosql.ecommerce.mapper;

import org.springframework.stereotype.Component;

import com.ejemplonosql.ecommerce.domain.model.Order;
import com.ejemplonosql.ecommerce.dto.OrderRequest;
import com.ejemplonosql.ecommerce.dto.OrderResponse;

@Component
public class OrderMapper {
    public OrderResponse toDTO(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setCreatedAt(order.getCreatedAt());
        orderResponse.setTotal(order.getTotal());
        orderResponse.setUserid(order.getUserid());
        orderResponse.setOrderLines(order.getOrderLines());
        return orderResponse;
    }

    public Order toEntity(OrderRequest dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setCreatedAt(dto.getCreatedAt());
        order.setTotal(dto.getTotal());
        order.setUserid(dto.getUserid());
        order.setOrderLines(dto.getOrderLines());
        return order;
    }
}
