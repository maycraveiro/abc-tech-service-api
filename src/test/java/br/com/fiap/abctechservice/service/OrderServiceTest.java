package br.com.fiap.abctechservice.service;

import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.repository.OrderRepository;
import br.com.fiap.abctechservice.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    private OrderService orderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);

        orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    public void order_service_not_null(){
        Assertions.assertNotNull(orderService);
    }

    @Test
    public void create_order_success() throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        newOrder.setServices(generate_mock_assistance(1));
        orderService.saveOrder(newOrder);

        verify(orderRepository, times(1)).save(newOrder);
    }

    @Test
    public void create_order_error_minimum() throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        newOrder.setServices(List.of());

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> orderService.saveOrder(newOrder));
        verify(orderRepository, times(0)).save(newOrder);
    }

    @Test
    public void create_order_error_maximum() throws Exception {
        Order newOrder = new Order();
        newOrder.setOperatorId(1234L);
        newOrder.setServices(generate_mock_assistance(20));

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> orderService.saveOrder(newOrder));
        verify(orderRepository, times(0)).save(newOrder);
    }

    private List<Assistance> generate_mock_assistance(int number) {
        ArrayList<Assistance> arrayList = new ArrayList<>();
        for (int x = 0; x < number; x++){
            arrayList.add(new Assistance(Integer.toUnsignedLong(x), "Mock service name", "Mock service description"));
        }
        return  arrayList;
    }
}