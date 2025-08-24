package com.codewithvihanga.store.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScooterDto {
    @JsonProperty("user_id")
    private Long id;
    private String model;
    private String description;
    private double pricePerHour;
    private boolean available;
    private String imageUrl;

}
