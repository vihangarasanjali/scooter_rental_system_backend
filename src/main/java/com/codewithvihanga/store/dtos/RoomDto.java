package com.codewithvihanga.store.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private Long id;

    @NotBlank(message = "Room name is required")
    private String name;

    private String description;

    @NotNull(message = "Price per night is required")
    @Min(value = 0, message = "Price must be positive")
    private Double pricePerNight;

    @NotNull(message = "Capacity is required.")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    private boolean available;

}

