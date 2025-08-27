package com.codewithvihanga.store.mappers;

import ch.qos.logback.core.model.ComponentModel;
import com.codewithvihanga.store.dtos.RoomDto;
import com.codewithvihanga.store.entities.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    @Mapping(target = "available", source = "available")
    Room toEntity(RoomDto roomDto);

    @Mapping(target = "available", source = "available")
    RoomDto toDto(Room room);
}
