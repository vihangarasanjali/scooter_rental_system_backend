package com.codewithvihanga.store.mappers;

import com.codewithvihanga.store.dtos.RegisterUserDto;
import com.codewithvihanga.store.dtos.UpdateUserDto;
import com.codewithvihanga.store.dtos.UserDto;
import com.codewithvihanga.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserDto request);
    void updateUser(UpdateUserDto request,@MappingTarget User user);
}
