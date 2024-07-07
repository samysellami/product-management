package com.axa.productmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.axa.productmanagement.models.Order;
import com.axa.productmanagement.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        
        orderRepository.delete(order);
    }
}
