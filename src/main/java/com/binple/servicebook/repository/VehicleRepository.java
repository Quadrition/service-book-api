package com.binple.servicebook.repository;

import java.util.Optional;

import com.binple.servicebook.model.Vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  Optional<Vehicle> findByChassisNumber(String chassisNumber);

  Optional<Vehicle> findByChassisNumberAndIdNot(String chassisNumber, Long id);

  Page<Vehicle> findByChassisNumberContaining(String chassisNumber, Pageable pageable);
}
