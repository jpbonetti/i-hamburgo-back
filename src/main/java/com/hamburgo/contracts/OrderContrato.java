package com.hamburgo.contracts;

import com.hamburgo.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public interface OrderContrato {

    @GetMapping("/findAll")
    ResponseEntity<List<Order>> findAll();

    @PostMapping("/save")
    void save(@RequestBody Order order);
}
