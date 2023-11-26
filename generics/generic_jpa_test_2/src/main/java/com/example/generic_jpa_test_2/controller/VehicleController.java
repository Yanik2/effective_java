package com.example.generic_jpa_test_2.controller;

import com.example.generic_jpa_test_2.model.Sedan;
import com.example.generic_jpa_test_2.model.Truck;
import com.example.generic_jpa_test_2.model.Van;
import com.example.generic_jpa_test_2.model.Vehicle;
import com.example.generic_jpa_test_2.service.SedanService;
import com.example.generic_jpa_test_2.service.TruckService;
import com.example.generic_jpa_test_2.service.VanService;
import com.example.generic_jpa_test_2.service.VehicleService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
  private final TruckService truckService;
  private final SedanService sedanService;
  private final VanService vanService;

  public VehicleController(TruckService truckService, VanService vanService, SedanService sedanService) {
    this.truckService = truckService;
    this.vanService = vanService;
    this.sedanService = sedanService;
  }

  @GetMapping("/truck")
  public List<String> getTrucks() {
    return findAll(truckService);
  }

  @PostMapping("/truck")
  public String createTruck(@RequestParam String name) {
   return createVehicle(new Truck(name), truckService).getBrand();
  }

  @GetMapping("/sedan")
  public List<String> getSedan() {
    return findAll(sedanService);
  }

  @PostMapping("/sedan")
  public String createSedan(@RequestParam String name) {
    return createVehicle(new Sedan(name), sedanService).getBrand();
  }

  @GetMapping("/van")
  public List<String> getVan() {
    return findAll(vanService);
  }

  @PostMapping("/van")
  public String createVan(@RequestParam String name) {
    return createVehicle(new Van(name), vanService).getBrand();
  }

  private <T extends Vehicle> T createVehicle(T vehicle, VehicleService<T> service) {
    return service.createVehicle(vehicle);
  }

  private List<String> findAll(VehicleService<? extends Vehicle> service) {
    return service.finaAll()
        .stream()
        .map(Vehicle::getBrand)
        .toList();
  }
}
