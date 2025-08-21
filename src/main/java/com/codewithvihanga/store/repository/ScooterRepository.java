package com.codewithvihanga.store.repository;

import com.codewithvihanga.store.entities.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterRepository extends JpaRepository<Scooter, Long> {
}
