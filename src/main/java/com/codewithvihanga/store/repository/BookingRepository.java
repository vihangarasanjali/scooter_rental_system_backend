package com.codewithvihanga.store.repository;

import com.codewithvihanga.store.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}