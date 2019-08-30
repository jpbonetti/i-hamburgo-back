package com.hamburgo.service;

import com.hamburgo.environment.OrderEnvironment;
import com.hamburgo.model.Order;
import com.hamburgo.repository.OrderRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        Long idOrder = 1L;

        when(orderRepository.findAll()).thenReturn(Arrays.asList(OrderEnvironment.createOrder()));

        List<Order> retorno = orderService.findAll();

        Assert.assertNotNull(retorno);
        Assert.assertEquals(1, retorno.size());
        Assert.assertEquals(idOrder, retorno.get(0).getId());
    }

    @Test
    public void testSaveEmptyDataBase() {
        Long idOrder = 1L;

        Order order = OrderEnvironment.createOrder();

        orderService.save(order);

        ArgumentCaptor<Order> argumentCaptor = ArgumentCaptor.forClass(Order.class);
        verify(orderRepository, times(1)).save(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(idOrder, argumentCaptor.getValue().getId());
    }

    @Test
    public void testSaveDataBaseNotEmpty() {
        Long idOrder = 2L;

        Order order = OrderEnvironment.createOrder();

        when(orderRepository.findFirstByOrderByIdAsc()).thenReturn(Optional.of(order));

        orderService.save(order);

        ArgumentCaptor<Order> argumentCaptor = ArgumentCaptor.forClass(Order.class);
        verify(orderRepository, times(1)).save(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(idOrder, argumentCaptor.getValue().getId());
    }

    @Test
    public void testDelete() {
        Long idOrder = 1L;

        orderService.delete(idOrder);

        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(orderRepository, times(1)).deleteById(argumentCaptor.capture());

        Assert.assertNotNull(argumentCaptor.getValue());
        Assert.assertEquals(idOrder, argumentCaptor.getValue());
    }
}
