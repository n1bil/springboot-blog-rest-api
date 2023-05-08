package com.springboot.blog.mapper;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.payload.CommentDto;

public class CommentMapper {

    // comment map to commentDto
    public static CommentDto mapToCommentDto(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .name(comment.getName())
                .email(comment.getEmail())
                .content(comment.getContent())
                .build();
    }

    // commentDto map to commentDto
    public static Comment mapToComment(CommentDto commentDto) {
        return Comment.builder()
                .id(commentDto.getId())
                .name(commentDto.getName())
                .email(commentDto.getEmail())
                .content(commentDto.getContent())
                .build();
    }
}
