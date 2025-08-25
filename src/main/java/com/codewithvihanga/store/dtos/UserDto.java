package com.codewithvihanga.store.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;



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