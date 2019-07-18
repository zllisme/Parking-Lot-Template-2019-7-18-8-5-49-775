package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByParkingLotName(String parkingLotName);

    Order findByPlateNumber(String plateNumber);
}
