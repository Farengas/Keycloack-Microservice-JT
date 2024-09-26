package com.javatechie.controller;

import com.javatechie.feign.FeignServiceUtil;
import com.javatechie.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feign")
public class FeignController {

@Autowired
    private  FeignServiceUtil feignServiceUtil;



    @GetMapping("/order")
   public List<Order> findAllOrders(){
        return feignServiceUtil.findAllOrders();
    }


    @PostMapping("/new")
    public Order createOrder (@RequestBody Order order){
        return feignServiceUtil.createOrder(order);
    }
}
