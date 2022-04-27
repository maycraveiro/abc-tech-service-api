package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.application.OrderApplication;
import br.com.fiap.abctechservice.application.dto.OrderDto;
import br.com.fiap.abctechservice.application.dto.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderApplication orderApplication;

    public OrderController(@Autowired OrderApplication orderApplication) {
        this.orderApplication = orderApplication;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderApplication.getOrder(id));
    }

    @PostMapping
    public ResponseEntity createOrder(@Valid @RequestBody OrderDto orderDto) {
        orderApplication.createOrder(orderDto);
        return ResponseEntity.ok().build();
    }
}
