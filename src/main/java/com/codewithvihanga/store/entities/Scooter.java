package com.codewithvihanga.store.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "scooters")
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double pricePerHour;

    private Boolean available = true;

    private String imageUrl;
}
