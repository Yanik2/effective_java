package com.example.generic_jpa_test_2.service;

import com.example.generic_jpa_test_2.model.Vehicle;
import com.example.generic_jpa_test_2.repository.VehicleRepository;
import java.util.List;

public abstract class AbstractVehicleService<T extends Vehicle> implements VehicleService<T> {
  private final VehicleRepository<T> vehicleRepository;

  protected AbstractVehicleService(VehicleRepository<T> vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public List<T> finaAll() {
    return vehicleRepository.findAll();
  }

  @Override
  public T createVehicle(T vehicle) {
    return vehicleRepository.save(vehicle);
  }
}
