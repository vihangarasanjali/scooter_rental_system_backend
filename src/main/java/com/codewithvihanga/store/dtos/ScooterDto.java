package com.codewithvihanga.store.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScooterDto {
    private Long id;
    private String model;
    private String description;
    private double pricePerHour;
    private boolean available;
    private String imageUrl;

}
