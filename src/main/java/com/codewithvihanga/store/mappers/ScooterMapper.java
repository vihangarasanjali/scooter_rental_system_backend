package com.codewithvihanga.store.mappers;

import com.codewithvihanga.store.dtos.ScooterDto;
import com.codewithvihanga.store.entities.Scooter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScooterMapper {
    ScooterDto toDto(Scooter scooter);
    Scooter toEntity(ScooterDto scooterDto);
}
