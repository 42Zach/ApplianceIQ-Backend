package com.applianceiq.applianceiq.service;

import com.applianceiq.applianceiq.model.ApplianceType;
import com.applianceiq.applianceiq.repository.ApplianceRepository;
import com.applianceiq.applianceiq.model.Appliance;
import com.applianceiq.applianceiq.repository.ApplianceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplianceService {
    private final ApplianceRepository applianceRepository;
    private final ApplianceTypeRepository applianceTypeRepository;

    @Autowired
    public ApplianceService(ApplianceRepository applianceRepository, ApplianceTypeRepository applianceTypeRepository) {
        this.applianceRepository = applianceRepository;
        this.applianceTypeRepository = applianceTypeRepository;
    }

    public List<ApplianceType> getApplianceTypes(Long applianceId) {
        return applianceTypeRepository.findByApplianceId(applianceId);
    }

    // Get all appliances
    public List<Appliance> getAllAppliances() {
        return applianceRepository.findAll();
    }

    // Get appliance by ID
    public Appliance getApplianceById(Long id) {
        return applianceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appliance not found with id: " + id));
    }

    // Save a new appliance
    public Appliance saveAppliance(Appliance appliance) {
        return applianceRepository.save(appliance);
    }

    // Update an existing appliance
    public Appliance updateAppliance(Long id, Appliance updatedAppliance) {
        Appliance existingAppliance = getApplianceById(id);
        existingAppliance.setName(updatedAppliance.getName());
        existingAppliance.setImage(updatedAppliance.getImage());
        return applianceRepository.save(existingAppliance);
    }

    // Delete an appliance
    public void deleteAppliance(Long id) {
        applianceRepository.deleteById(id);
    }
}
