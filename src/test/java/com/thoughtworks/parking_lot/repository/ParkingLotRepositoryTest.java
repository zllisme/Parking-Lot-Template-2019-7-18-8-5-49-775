package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ParkingLotRepositoryTest {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Test
    @DirtiesContext
    public void should_return_parking_lot_has_given_name() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("testtest");
        parkingLotRepository.save(parkingLot);

        //when
        ParkingLot result = parkingLotRepository.findByName("testtest");

        //then
        Assertions.assertEquals("testtest", result.getName());

    }

}