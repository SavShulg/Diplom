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
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private Integer author;
    private String authorComment;
    private String authorFirstName;
    private Long editComment;
    private String text;

}