package com.example.generic_jpa_test_2.service;

import com.example.generic_jpa_test_2.model.Vehicle;
import java.util.List;

public interface VehicleService<T> {
  List<T> finaAll();
  T createVehicle(T vehicle);
}
