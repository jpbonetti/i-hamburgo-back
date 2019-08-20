package com.hamburgo.service;

import com.hamburgo.model.Order;
import com.hamburgo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void delete(Long idOrder) {
        orderRepository.deleteById(idOrder);
    }
}
