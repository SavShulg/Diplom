package ru.skypro.homework.bd.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Login")
public class Login {
    @Id
    @GeneratedValue
    private String username;
    private String password;
    private Long id;

}
