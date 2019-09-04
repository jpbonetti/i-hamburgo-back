package com.hamburgo.resource;

import com.hamburgo.contracts.OrderContrato;
import com.hamburgo.model.Order;
import com.hamburgo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Long save(@RequestBody Order order) {
        return orderService.save(order).getId();
    }

    @Override
    public void delete(@PathVariable("idOrder") Long idOrder) {
        orderService.delete(idOrder);
    }
}