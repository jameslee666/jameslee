package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Order;
import com.packt.webstore.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lixindi on 2017/1/5.
 */
@Repository
public class InMemoryOrderRepositoryImpl implements OrderRepository {
    private Map<Long, Order> listOfOrders;
    private long nextOrderId;

    public InMemoryOrderRepositoryImpl() {
        listOfOrders = new HashMap<Long, Order>();
        nextOrderId = 1000;
    }

    public Long saveOrder(Order order) {
        order.setOrderId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        return order.getOrderId();
    }

    private synchronized long getNextOrderId() {
        return nextOrderId++;
    }
}
