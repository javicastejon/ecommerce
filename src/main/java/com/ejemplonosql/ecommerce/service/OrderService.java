package com.ejemplonosql.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplonosql.ecommerce.domain.model.Order;
import com.ejemplonosql.ecommerce.domain.repository.OrderRepository;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Order createOrder(Order user){
        Order userdb = orderRepository.save(user);
        
        return userdb;
    }

    public void removeOrder(String id){
        orderRepository.deleteById(id);
        
    }

    public Optional<Order> getOrderById(String id){
        return orderRepository.findById(id);
    }

    // Importante: se tiene que usar un modelo distinto ya que el objeto enviado está detached
    public void update(Order order) {
        orderRepository
                .findById(order.getId()) 
                .ifPresent(orderdb -> {
                    orderdb.setCreatedAt(order.getCreatedAt());
                    orderdb.setTotal(order.getTotal());
                    orderdb.setUserid(order.getUserid());
                    orderdb.setOrderLines(order.getOrderLines());
                    orderRepository.save(orderdb);
                });
    }

    public void deleteOrder(String id){
        orderRepository.deleteById(id);
    }   

    public List<Order> getAll(){
        return orderRepository.findAll();
    }
}
