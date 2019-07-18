package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @PostMapping
    public ParkingLot addParkingLot(@RequestBody ParkingLot parkingLot) {
        return parkingLotService.addParkingLot(parkingLot);
    }

    @DeleteMapping("/{id}")
    public void DeleteParkingLot(@PathVariable Long id) {
         parkingLotService.deleteParkingLot(id);
    }

    @GetMapping
    public List<ParkingLot> viewParkingLotPaging(@RequestParam int pageNum) {
        return parkingLotService.getParkingLotsPaging(pageNum);
    }

    @GetMapping("/{id}")
    public ParkingLot viewParkingLot(@PathVariable Long id) {
        return parkingLotService.getParkingLot(id);
    }

    @PutMapping
    public ParkingLot updateParkingLot(@RequestBody ParkingLot parkingLot) {
        return parkingLotService.updateParkingLot(parkingLot);
    }
}
