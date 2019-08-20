package com.hamburgo.service;

import com.hamburgo.model.Order;
import com.hamburgo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order) {
        order.setId(getLastOrderId());
        return orderRepository.save(order);
    }

    public void delete(Long idOrder) {
        orderRepository.deleteById(idOrder);
    }

    private Long getLastOrderId() {
        Long id;

        Optional<Order> lastOrder = orderRepository.findFirstByOrderByIdAsc();
        if (lastOrder.isPresent()) {
            id = lastOrder.get().getId() + 1;
        } else {
            id = 1L;
        }

        return id;
    }
}
