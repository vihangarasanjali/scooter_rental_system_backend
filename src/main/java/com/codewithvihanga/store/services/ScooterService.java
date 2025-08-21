package com.codewithvihanga.store.services;

import com.codewithvihanga.store.entities.Scooter;
import com.codewithvihanga.store.repository.ScooterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScooterService {

    private final ScooterRepository scooterRepository;

    public ScooterService(ScooterRepository scooterRepository) {
        this.scooterRepository = scooterRepository;
    }

    public List<Scooter> getAllScooters() {
        return scooterRepository.findAll();
    }

    public Scooter getScooterById(Long id) {
        return scooterRepository.findById(id).orElse(null);
    }

    public Scooter saveScooter(Scooter scooter) {
        return scooterRepository.save(scooter);
    }

    public Scooter updateScooter(Long id, Scooter updatedScooter) {
        return scooterRepository.findById(id)
                .map(scooter -> {
                    scooter.setModel(updatedScooter.getModel());
                    scooter.setDescription(updatedScooter.getDescription());
                    scooter.setPricePerHour(updatedScooter.getPricePerHour());
                    scooter.setAvailable(updatedScooter.getAvailable());
                    scooter.setImageUrl(updatedScooter.getImageUrl());
                    return scooterRepository.save(scooter);
                })
                .orElse(null);
    }

    public void deleteScooter(Long id) {
        scooterRepository.deleteById(id);
    }
}
