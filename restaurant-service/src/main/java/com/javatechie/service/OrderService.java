package com.javatechie.service;


import com.javatechie.dto.OrderResponseDTO;
import com.javatechie.model.Order;
import com.javatechie.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface OrderService {

    List<Order> findAllOrders();

    Order createOrder(Order order);

    void deleteOrderById(Long idOrdine);


}
