package com.binple.servicebook.repository;

import com.binple.servicebook.model.VehicleService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleServiceRepository extends JpaRepository<VehicleService, Long> {

  @Query("SELECT vs FROM VehicleService as vs WHERE vehicle_id = :vehicleId")
  Page<VehicleService> findByVehicle(@Param("vehicleId") Long vehicleId, Pageable pageable);
}
