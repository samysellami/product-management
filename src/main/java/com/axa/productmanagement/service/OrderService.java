package com.axa.productmanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.axa.productmanagement.models.Order;
import com.axa.productmanagement.models.Product;
import com.axa.productmanagement.models.User;
import com.axa.productmanagement.repository.OrderRepository;
import com.axa.productmanagement.repository.ProductRepository;
import com.axa.productmanagement.repository.UserRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(Long userId, List<Long> productIds) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        List<Product> products = productRepository.findAllById(productIds);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("No products found");
        }

        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        order.setStatus("Pending");

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("The requested order does not exit"));
        
        order.setStatus(status);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("The requested order does not exit"));
        
        orderRepository.delete(order);
    }
}
