package br.com.fiap.abctechservice.service;


import br.com.fiap.abctechservice.model.Order;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order) throws Exception;

    List<Order> listOrdersByOperator(Long operatorId);
}