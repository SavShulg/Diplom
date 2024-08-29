package ru.skypro.homework.bd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailsDto {
    private Integer id;
    private String email;
    private String password;
    private Role role;

    public Object getPassword(UserDetailsDto userDetailsDto) {
        return userDetailsDto.getPassword();
    }

    public Object getEmail(UserDetailsDto userDetailsDto) {
        return userDetailsDto.getEmail();
    }
}