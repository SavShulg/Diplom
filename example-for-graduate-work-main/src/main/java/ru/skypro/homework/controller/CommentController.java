package ru.skypro.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.bd.dto.CommentDto;
import ru.skypro.homework.service.impl.CommentService;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto comment) {
        commentService.commentAdd(comment);
        return ResponseEntity.ok(new CommentDto());
    }

    @PutMapping
    public ResponseEntity<CommentDto> editComment(@RequestBody CommentDto comments) {
        commentService.editComment(comments);
        return ResponseEntity.ok(new CommentDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> findCommentById(@PathVariable Long id) {
        commentService.findCommentById(id);
        return ResponseEntity.ok(new CommentDto());
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments() {
        commentService.getAllComments();
        return ResponseEntity.ok(new ArrayList<CommentDto>());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long id, @RequestBody CommentDto comment) {
        commentService.editComment(comment);
        commentService.findCommentById(id);
        return ResponseEntity.ok(new CommentDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}