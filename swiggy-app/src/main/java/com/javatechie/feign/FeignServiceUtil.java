package com.javatechie.feign;

import com.javatechie.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "RESTAURANT-SERVICE")
public interface FeignServiceUtil {


    @GetMapping("/restaurant/order")
    List<Order> findAllOrders();


    @PostMapping("/restaurant/new")
    public Order createOrder (@RequestBody Order order);
}
