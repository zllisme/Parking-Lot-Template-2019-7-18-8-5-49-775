package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ParkingLotRepository parkingLotRepository;

    public Order createOrder(Order order) {
        if(!isHasValidPosition(order.getParkingLotName())){
            System.out.println("no position!");
            return null;
        }
        return orderRepository.saveAndFlush(order);

    }

    private boolean isHasValidPosition(String parkingLotName) {
        boolean result = true;
        ParkingLot parkingLot = parkingLotRepository.findByName(parkingLotName);
        List<Order> sameParkingLotOrders = orderRepository.findAllByParkingLotName(parkingLotName);
        List<Order> validOrders = sameParkingLotOrders.stream().filter(Order::getState).collect(Collectors.toList());
        int occupiedPosition = validOrders.size();
        int validPosition = parkingLot.getCapacity() - occupiedPosition;
        if(validPosition == 0) {
            result = false;
        }
        return result;
    }

    public Order updateOrder(Order order) {
        Order existedOrder = orderRepository.findByPlateNumber(order.getPlateNumber());
        if(!existedOrder.getState()) {
            return null;
        }
        existedOrder.setEndTime(order.getEndTime());
        existedOrder.setState(false);
        return orderRepository.saveAndFlush(existedOrder);
    }
}
