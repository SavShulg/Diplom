package ru.skypro.homework.bd.dto;

import lombok.*;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterDto {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;
    private Long id;
    @Pattern(regexp = "\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}")
    private String phone;
}
