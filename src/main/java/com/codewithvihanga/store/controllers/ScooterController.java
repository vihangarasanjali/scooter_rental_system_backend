package com.codewithvihanga.store.controllers;

import com.codewithvihanga.store.controllers.ScooterController;
import com.codewithvihanga.store.entities.Scooter;
import com.codewithvihanga.store.services.ScooterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scooters")
public class ScooterController {

    private final ScooterService scooterService;

    public ScooterController(ScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @GetMapping
    public List<Scooter> getAllScooters() {
        return scooterService.getAllScooters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scooter> getScooterById(@PathVariable Long id) {
        Scooter scooter = scooterService.getScooterById(id);
        return (scooter != null) ? ResponseEntity.ok(scooter) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Scooter createScooter(@RequestBody Scooter scooter) {
        return scooterService.saveScooter(scooter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scooter> updateScooter(@PathVariable Long id, @RequestBody Scooter scooter) {
        Scooter updated = scooterService.updateScooter(id, scooter);
        return (updated != null) ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScooter(@PathVariable Long id) {
        scooterService.deleteScooter(id);
        return ResponseEntity.noContent().build();
    }
}
