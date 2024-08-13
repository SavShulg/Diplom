package ru.skypro.homework.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Data
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

