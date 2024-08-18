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
@Table(name = "Adds")
public class Add {

    @Id
    @GeneratedValue
    private long id;
    private long authorId;
    private String image;
    private int price;
    private String title;

}