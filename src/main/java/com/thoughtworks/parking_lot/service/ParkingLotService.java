package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    private final static int PAGE_SIZE = 15;

    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.saveAndFlush(parkingLot);
    }

    public void deleteParkingLot(Long id) {
        parkingLotRepository.deleteById(id);
    }

    public List<ParkingLot> getParkingLotsPaging(int pageNum) {
        return parkingLotRepository.findAll().subList((pageNum-1) * PAGE_SIZE, pageNum * PAGE_SIZE);


    }

    public ParkingLot getParkingLot(Long id) {
        return parkingLotRepository.findById(id).orElse(null);
    }

    public ParkingLot updateParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.saveAndFlush(parkingLot);
    }
}
