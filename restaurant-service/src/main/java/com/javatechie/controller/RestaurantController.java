package com.javatechie.controller;

import com.javatechie.model.Order;
import com.javatechie.repository.OrderRepository;
import com.javatechie.service.OrderService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@AllArgsConstructor
public class RestaurantController {


    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping("/order")
    public List<Order> findAllOrders(){
        return  orderService.findAllOrders();
    }

    @PostMapping("/new")
    public Order createOrder (@RequestBody Order order){
        return orderService.createOrder(order);
    }

}
