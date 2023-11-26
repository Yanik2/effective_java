package com.example.generic_jpa_test_2.repository;

import com.example.generic_jpa_test_2.model.Vehicle;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface VehicleRepository<T extends Vehicle> extends JpaRepository<T, Long> {
  Optional<T> findByBrand(String brand);
}
