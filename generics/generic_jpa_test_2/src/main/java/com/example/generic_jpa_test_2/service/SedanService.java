package com.example.generic_jpa_test_2.service;

import com.example.generic_jpa_test_2.model.Sedan;
import com.example.generic_jpa_test_2.repository.SedanRepository;
import org.springframework.stereotype.Service;

@Service
public class SedanService extends AbstractVehicleService<Sedan> {
  public SedanService(SedanRepository sedanRepository) {
    super(sedanRepository);
  }
}
