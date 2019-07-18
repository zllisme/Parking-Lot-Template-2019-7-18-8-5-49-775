package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @PostMapping
    ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot) {
        return parkingLotService.addParkingLot(parkingLot);
    }
}
