package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    public OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @PutMapping
    public Order updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

}
