package com.codewithvihanga.store.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.codewithvihanga.demomosh.entities.User}
 */
@Getter
@AllArgsConstructor
public class UserDto  {
    @JsonProperty("user_id")
    private Long id;
    private String name;
    private String email;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDate createdAt;
}