package br.com.fiap.abctechservice.application;

import br.com.fiap.abctechservice.application.dto.OrderDto;
import br.com.fiap.abctechservice.application.dto.OrderResponseDto;

public interface OrderApplication {

    void createOrder(OrderDto orderDto);
//    public OrderResponseDto getOrder(Long id);
}
