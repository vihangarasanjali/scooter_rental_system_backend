package com.codewithvihanga.store.mappers;

import com.codewithvihanga.store.dtos.BookingDto;
import com.codewithvihanga.store.entities.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "room.id", target = "roomId")
    @Mapping(source = "scooter.id", target = "scooterId")
    BookingDto toDto(Booking booking);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roomId", target = "room.id")
    @Mapping(source = "scooterId", target = "scooter.id")
    Booking toEntity(BookingDto dto);
}

