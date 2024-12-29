package com.applianceiq.applianceiq.controller;

import com.applianceiq.applianceiq.model.Appliance;
import com.applianceiq.applianceiq.model.ApplianceType;
import com.applianceiq.applianceiq.repository.ApplianceRepository;
import com.applianceiq.applianceiq.service.ApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appliances")
@CrossOrigin(origins = "https://frolicking-kitsune-3909f0.netlify.app/")
//@CrossOrigin(origins = "http://localhost:5173")
public class ApplianceController {

    private final ApplianceService applianceService;

    @Autowired
    private ApplianceRepository repository;

    public ApplianceController(ApplianceService applianceService) {
        this.applianceService = applianceService;
    }

    @GetMapping
    public List<Appliance> getAllAppliances() {
        return repository.findAll();
    }

    @GetMapping("/{id}/types")
    public List<ApplianceType> getApplianceTypes(@PathVariable Long id) {
        return applianceService.getApplianceTypes(id);
    }

    @GetMapping("/{id}")
    public Appliance getApplianceById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appliance not found"));
    }

    @PostMapping
    public ResponseEntity<Appliance> createAppliance(@RequestBody Appliance appliance) {
        Appliance createdAppliance = applianceService.saveAppliance(appliance);
        return ResponseEntity.ok(createdAppliance);
    }

    // PUT: Update an existing appliance
    @PutMapping("/{id}")
    public ResponseEntity<Appliance> updateAppliance(@PathVariable Long id, @RequestBody Appliance appliance) {
        Appliance updatedAppliance = applianceService.updateAppliance(id, appliance);
        return ResponseEntity.ok(updatedAppliance);
    }

    // DELETE: Delete an appliance by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppliance(@PathVariable Long id) {
        applianceService.deleteAppliance(id);
        return ResponseEntity.noContent().build();
    }
}