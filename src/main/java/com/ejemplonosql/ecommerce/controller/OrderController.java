package com.ejemplonosql.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplonosql.ecommerce.domain.model.Order;
import com.ejemplonosql.ecommerce.dto.OrderRequest;
import com.ejemplonosql.ecommerce.dto.OrderResponse;
import com.ejemplonosql.ecommerce.mapper.OrderMapper;
import com.ejemplonosql.ecommerce.mapper.OrderMapper;
import com.ejemplonosql.ecommerce.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper mapper;

    @PostMapping
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(mapper.toEntity(orderRequest));
        return mapper.toDTO(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.removeOrder(id);
    }

    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable String id) {
        Order user = orderService.getOrderById(id).orElse(null);
        return mapper.toDTO(user);
    }

    @PutMapping("/{id}")
    public OrderResponse updateOrder(@RequestBody OrderRequest orderRequest){
        Order orderEntity = mapper.toEntity(orderRequest);
        orderService.update(orderEntity);
        return mapper.toDTO(orderEntity);
    }

    @GetMapping("/getall")
    public List<Order> getAllOrders() {
        return orderService.getAll();
        
    }
}