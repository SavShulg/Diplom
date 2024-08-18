package ru.skypro.homework.bd.muppas;

import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.CommentDto;
import ru.skypro.homework.bd.entity.Comment;
@Service
public class CommentMupp {
    public CommentDto toDto(Comment comment) {
        CommentDto ComDto = new CommentDto();
        ComDto.setId(comment.getId());
        ComDto.setText(comment.getText());
        ComDto.setAuthor(comment.getAuthor());
        ComDto.setAuthorComment(comment.getAuthorComment());
        ComDto.setEditComment(comment.getEditComment());
        ComDto.setAuthorFirstName(comment.getAuthorFirstName());
        return ComDto;
    }
    public  Comment toEntity(CommentDto commentDto) {
        Comment ComEntity = new Comment();
        ComEntity.setId(commentDto.getId());
        ComEntity.setText(commentDto.getText());
        ComEntity.setAuthor(commentDto.getAuthor());
        ComEntity.setAuthorComment(commentDto.getAuthorComment());
        ComEntity.setEditComment(commentDto.getEditComment());
        ComEntity.setAuthorFirstName(commentDto.getAuthorFirstName());
        return ComEntity;
    }
}
