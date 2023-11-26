package com.example.generic_jpa_test_2.service;

import com.example.generic_jpa_test_2.model.Van;
import com.example.generic_jpa_test_2.repository.VanRepository;
import com.example.generic_jpa_test_2.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VanService extends AbstractVehicleService<Van> {
  public VanService(VehicleRepository<Van> vehicleRepository) {
    super(vehicleRepository);
  }
}
