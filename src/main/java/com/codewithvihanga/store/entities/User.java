package com.codewithvihanga.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "users", schema = "schema")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ColumnDefault("'GUEST'")
    @Lob
    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user")
    private Set<Booking> bookings = new LinkedHashSet<>();

}