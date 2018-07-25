package com.vkeline.modules.sys.dao;

import com.vkeline.modules.sys.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDao extends JpaRepository<VehicleEntity, String>{

    VehicleEntity findVehicleEntityById(String id);
}
