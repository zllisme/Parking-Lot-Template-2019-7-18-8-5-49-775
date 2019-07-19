package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ParkingLotRepository parkingLotRepository;

    public Order createOrder(Order order) {
        if(!isHasValidPosstion(order.getParkingLotName())){
            System.out.println("no position!");
            return null;
        }
        return orderRepository.saveAndFlush(order);

    }

    private boolean isHasValidPosstion(String parkingLotName) {
        boolean result = true;
        ParkingLot parkingLot = parkingLotRepository.findByName(parkingLotName);
        List<Order> sameParkingLotOrders = orderRepository.findAllByParkingLotName(parkingLotName);
        int occupiedPosition = sameParkingLotOrders.size();
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
