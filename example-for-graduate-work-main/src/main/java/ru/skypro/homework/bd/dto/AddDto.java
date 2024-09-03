package ru.skypro.homework.bd.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddDto {

    private long id;
    private String description;
    private String image;
    private int price;
    private String title;

}