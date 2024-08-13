package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.dto.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    default Comment findByCommentId(long commentId) {
        return null;
    }

}