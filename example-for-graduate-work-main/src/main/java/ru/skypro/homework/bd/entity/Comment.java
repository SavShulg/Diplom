package ru.skypro.homework.bd.entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "adds_id")
    private Add add;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}