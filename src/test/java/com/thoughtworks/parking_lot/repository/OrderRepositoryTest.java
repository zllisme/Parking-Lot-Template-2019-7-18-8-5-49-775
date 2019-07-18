package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.Order;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;


    @Test
    @DirtiesContext
    public void should_return_order_has_given_parking_lot_name() {
        //given
        Order order = new Order();
        order.setParkingLotName("testtest");
        orderRepository.save(order);

        //when
        List<Order> result = orderRepository.findAllByParkingLotName("testtest");

        //then
        Assertions.assertEquals("testtest", result.get(0).getParkingLotName());

    }

    @Test
    @DirtiesContext
    public void should_return_order_has_given_plate_number() {
        //given
        Order order = new Order();
        order.setPlateNumber("testtest");
        orderRepository.save(order);

        //when
        Order result = orderRepository.findByPlateNumber("testtest");

        //then
        Assertions.assertEquals("testtest", result.getPlateNumber());

    }
}