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
@CrossOrigin(origins = "http://localhost:5173")
public class ApplianceController {
//    private List<Appliance> appliances = List.of(
//            new Appliance(1L, "Washer", "/images/washing_machine.png"),
//            new Appliance(2L, "Dryer", "/images/clothes_dryer.png"),
//            new Appliance(3L, "Refrigerator", "/images/refrigerator.png"),
//            new Appliance(4L, "Dishwasher", "/images/dishwasher.png"),
//            new Appliance(5L, "Range", "/images/range.png"),
//            new Appliance(6L, "Microwave", "/images/microwave.png")
//    );

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

//@RestController
//public class ApplianceController {
//    @Autowired
//    private ApplianceService applianceService;
//
//    @GetMapping("/api/appliances")
//    public List<Appliance> getAllAppliances() {
//        return applianceService.getAllAppliances();
//    }
//
//    @GetMapping("/api/appliances/{id}")
//    public Optional<Appliance> getApplianceById(@PathVariable Long id) {
//        return applianceService.getApplianceById(id);
//    }
//}