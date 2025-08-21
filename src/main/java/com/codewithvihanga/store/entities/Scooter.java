package com.codewithvihanga.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "scooters", schema = "schema")
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "model", nullable = false, length = 100)
    private String model;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "price_per_hour", nullable = false)
    private Double pricePerHour;

    @ColumnDefault("1")
    @Column(name = "available")
    private Boolean available;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(mappedBy = "scooter")
    private Set<Booking> bookings = new LinkedHashSet<>();

}