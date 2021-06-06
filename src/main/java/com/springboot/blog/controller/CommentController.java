package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/createComment")
    private ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable(value = "postId") long postId) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/getComments")
    private ResponseEntity<List<CommentDto>> getCommentsByPostId(@PathVariable(value = "postId") long postId) {
        return new ResponseEntity<>(commentService.getCommentsByPostId(postId), HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/getComments/{commentId}")
    private ResponseEntity<CommentDto> getCommentsByCommentId(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId) {
        return new ResponseEntity<>(commentService.getCommentByCommentId(postId, commentId), HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/getComments/{commentId}")
    private ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto commentDto, @PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId) {
        return new ResponseEntity<>(commentService.updateComment(postId, commentId, commentDto), HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/getComments/{commentId}")
    private ResponseEntity<String> deleteComment(@PathVariable(value = "postId") long postId, @PathVariable(value = "commentId") long commentId) {
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }

}
