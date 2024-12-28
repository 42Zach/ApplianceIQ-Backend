package com.applianceiq.applianceiq.repository;

import com.applianceiq.applianceiq.model.ApplianceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplianceTypeRepository extends JpaRepository<ApplianceType, Long> {
    List<ApplianceType> findByApplianceId(Long applianceId);
}