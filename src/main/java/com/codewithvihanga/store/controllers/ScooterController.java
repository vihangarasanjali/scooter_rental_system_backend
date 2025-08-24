package com.codewithvihanga.store.controllers;


import com.codewithvihanga.store.dtos.ScooterDto;
import com.codewithvihanga.store.entities.Scooter;
import com.codewithvihanga.store.mappers.ScooterMapper;
import com.codewithvihanga.store.services.ScooterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/scooters")
public class ScooterController {

    private final ScooterService scooterService;
    private final ScooterMapper scooterMapper;

    @GetMapping
    public List<ScooterDto> getAllScooters(
        @RequestParam(required = false,defaultValue = "", name="sort") String sort
    ) {
        if(!Set.of("model", "description").contains(sort))
            sort = "model";
        return scooterService.getAllScooters(sort)
                .stream()
                .map(scooterMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScooterDto> getScooterById(@PathVariable Long id) {
        return scooterService.getScooterById(id)
                .map(scooterMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ScooterDto> createScooter(@RequestBody ScooterDto scooterDto) {
        Scooter scooter = scooterMapper.toEntity(scooterDto);
        Scooter saved = scooterService.saveScooter(scooter);
        return ResponseEntity.ok(scooterMapper.toDto(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScooterDto> updateScooter(@PathVariable Long id, @RequestBody ScooterDto scooterDto) {
        Scooter updated = scooterService.updateScooter(id, scooterMapper.toEntity(scooterDto));
        return (updated != null) ? ResponseEntity.ok(scooterMapper.toDto(updated)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScooter(@PathVariable Long id) {
        scooterService.deleteScooter(id);
        return ResponseEntity.noContent().build();
    }
}

