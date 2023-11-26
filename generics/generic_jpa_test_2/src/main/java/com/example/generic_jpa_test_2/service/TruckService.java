package com.example.generic_jpa_test_2.service;

import com.example.generic_jpa_test_2.model.Truck;
import com.example.generic_jpa_test_2.repository.TruckRepository;
import com.example.generic_jpa_test_2.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class TruckService extends AbstractVehicleService<Truck> {

  public TruckService(VehicleRepository<Truck> vehicleRepository) {
    super(vehicleRepository);
  }
}
