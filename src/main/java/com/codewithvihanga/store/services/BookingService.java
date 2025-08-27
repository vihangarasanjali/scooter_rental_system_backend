package com.codewithvihanga.store.services;

import com.codewithvihanga.store.entities.*;
import com.codewithvihanga.store.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ScooterRepository scooterRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public Booking saveBooking(Booking booking) {
        // calculate total price
        long hours = Duration.between(booking.getStartDatetime(), booking.getEndDatetime()).toHours();
        long days = Duration.between(booking.getStartDatetime(), booking.getEndDatetime()).toDays();

        if (booking.getRoom() != null) {
            booking.setTotalPrice(booking.getRoom().getPricePerNight() * (days == 0 ? 1 : days));
        } else if (booking.getScooter() != null) {
            booking.setTotalPrice(booking.getScooter().getPricePerHour() * (hours == 0 ? 1 : hours));
        }

        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
