package ru.skypro.homework.bd.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


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
    private String description;
    private Integer image;
    private int price;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Add add = (Add) o;
        return Objects.equals(price, add.price)
                && Objects.equals(title, add.title)
                && Objects.equals(description, add.description)
                && Objects.equals(user, add.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, title, description, user);
    }

    @OneToMany(mappedBy = "add", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

}