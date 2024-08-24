package ru.skypro.homework.bd.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class NewPassword {
    @Size(min = 8, max = 16)
    private String currentPassword;
    @Size(min = 8, max = 16)
    private String newPassword;

}
