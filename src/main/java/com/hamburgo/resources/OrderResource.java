package com.hamburgo.resources;

import com.hamburgo.contracts.OrderContrato;
import com.hamburgo.model.Order;
import com.hamburgo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderResource implements OrderContrato {

    @Autowired
    private OrderService orderService;

    @Override
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @Override
    public void save(@RequestBody Order order) {
        orderService.save(order);
    }
}