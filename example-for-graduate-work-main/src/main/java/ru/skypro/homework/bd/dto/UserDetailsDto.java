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
    private String userName;
    private String phone;
    private String password;
    private Role role;

    public Object getPassword(UserDetailsDto userDetailsDto) {
        return userDetailsDto.getPassword();
    }

    public Object getUsername(UserDetailsDto userDetailsDto) {
        return userDetailsDto.getUserName();
    }
}