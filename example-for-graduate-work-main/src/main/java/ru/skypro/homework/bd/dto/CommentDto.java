package ru.skypro.homework.bd.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private Long id;
    private Integer author;
    private String authorComment;
    private String authorFirstName;
    private Long editComment;
    private String text;

}