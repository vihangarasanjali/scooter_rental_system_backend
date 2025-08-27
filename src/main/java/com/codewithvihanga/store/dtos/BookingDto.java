package com.codewithvihanga.store.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long id;

    @NotNull(message = "User ID is required")
    private Long userId;

    private Long roomId;//optional
    private Long scooterId;

    @NotNull(message = "Start datetime is required")
    @Future(message = "Start date must be in the future")
    private Instant startDatetime;

    @NotNull(message = "End date-time is required ")
    private Instant endDatetime;

    private Double totalPrice;

}
