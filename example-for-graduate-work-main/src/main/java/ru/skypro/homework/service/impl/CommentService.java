package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.CommentDto;
import ru.skypro.homework.bd.entity.Comment;
import ru.skypro.homework.bd.muppas.CommentMupp;
import ru.skypro.homework.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {

    private final CommentMupp commentMupp;

    private final CommentRepository commentRepository;

    public CommentService(CommentMupp commentMupp, CommentRepository commentRepository) {
        this.commentMupp = commentMupp;
        this.commentRepository = commentRepository;
    }

    public CommentDto commentAdd(CommentDto commentDto) {
        var entity = commentMupp.toEntity(commentDto);
        var save = commentRepository.save(entity);
        return commentMupp.toDto(save);
    }

    public CommentDto editComment(CommentDto comment) {
        var entity = commentMupp.toEntity(comment);
        var edit = commentRepository.save(entity);
        return commentMupp.toDto((Comment) edit);

    }
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
    public Comment findCommentById(long id) {
        return commentRepository.findById(id);
    }
    public Comment updateComment (Comment comment) {
        return commentRepository.save(comment);
    }

}