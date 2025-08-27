package com.codewithvihanga.store.controllers;

import com.codewithvihanga.store.dtos.BookingDto;
import com.codewithvihanga.store.entities.Booking;
import com.codewithvihanga.store.entities.Room;
import com.codewithvihanga.store.entities.Scooter;
import com.codewithvihanga.store.entities.User;
import com.codewithvihanga.store.mappers.BookingMapper;
import com.codewithvihanga.store.repository.RoomRepository;
import com.codewithvihanga.store.repository.ScooterRepository;
import com.codewithvihanga.store.repository.UserRepository;
import com.codewithvihanga.store.services.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;
    private final BookingMapper bookingMapper;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final ScooterRepository scooterRepository;

    @GetMapping
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBookings()
                .stream()
                .map(bookingMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id)
                .map(bookingMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@Valid @RequestBody BookingDto bookingDto) {
        // Convert manually instead of full mapper
        Booking booking = new Booking();

        // Fetch user (required)
        User user = userRepository.findById(bookingDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUser(user);

        // Optional room
        if (bookingDto.getRoomId() != null) {
            Room room = roomRepository.findById(bookingDto.getRoomId())
                    .orElseThrow(() -> new RuntimeException("Room not found"));
            booking.setRoom(room);
        }

        // Optional scooter
        if (bookingDto.getScooterId() != null) {
            Scooter scooter = scooterRepository.findById(bookingDto.getScooterId())
                    .orElseThrow(() -> new RuntimeException("Scooter not found"));
            booking.setScooter(scooter);
        }

        // Dates
        booking.setStartDatetime(bookingDto.getStartDatetime());
        booking.setEndDatetime(bookingDto.getEndDatetime());

        // Save and calculate price in service
        Booking saved = bookingService.saveBooking(booking);

        return ResponseEntity.ok(bookingMapper.toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
