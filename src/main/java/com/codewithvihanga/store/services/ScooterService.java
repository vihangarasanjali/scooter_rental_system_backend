package com.codewithvihanga.store.services;

import com.codewithvihanga.store.entities.Scooter;
import com.codewithvihanga.store.repository.ScooterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScooterService {

    private final ScooterRepository scooterRepository;

    // Get all scooters
    public List<Scooter> getAllScooters() {
        return scooterRepository.findAll();
    }

    // Get scooter by ID
    public Optional<Scooter> getScooterById(Long id) {
        return scooterRepository.findById(id);
    }

    // Save new scooter
    public Scooter saveScooter(Scooter scooter) {
        return scooterRepository.save(scooter);
    }

    // Update scooter
    public Scooter updateScooter(Long id, Scooter updatedScooter) {
        return scooterRepository.findById(id)
                .map(existing -> {
                    existing.setModel(updatedScooter.getModel());
                    existing.setDescription(updatedScooter.getDescription());
                    existing.setPricePerHour(updatedScooter.getPricePerHour());
                    existing.setAvailable(updatedScooter.getAvailable());
                    existing.setImageUrl(updatedScooter.getImageUrl());
                    return scooterRepository.save(existing);
                })
                .orElse(null);
    }

    // Delete scooter
    public void deleteScooter(Long id) {
        scooterRepository.deleteById(id);
    }
}
