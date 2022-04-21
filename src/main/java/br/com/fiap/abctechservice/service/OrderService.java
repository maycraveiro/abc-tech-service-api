package br.com.fiap.abctechservice.service;

import br.com.fiap.abctechservice.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order, List<Long> arrayAssists);
    Order getOrderById(Long orderId);
//    List<Order> listOrdersByOperator(Long operatorId);
}