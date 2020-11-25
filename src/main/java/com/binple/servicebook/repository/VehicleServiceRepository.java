package com.binple.servicebook.repository;

import com.binple.servicebook.model.VehicleService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleServiceRepository extends JpaRepository<VehicleService, Long> {

}
