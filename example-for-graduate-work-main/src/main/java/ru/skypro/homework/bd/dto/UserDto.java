package ru.skypro.homework.bd.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;

}