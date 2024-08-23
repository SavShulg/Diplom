package ru.skypro.homework.bd.entity;

import lombok.*;
import ru.skypro.homework.bd.dto.Role;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Register")
public class Register {

    @Id
    @GeneratedValue
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private Role role;
    private Long id;

}
