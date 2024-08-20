package ru.skypro.homework.bd.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "add", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

}