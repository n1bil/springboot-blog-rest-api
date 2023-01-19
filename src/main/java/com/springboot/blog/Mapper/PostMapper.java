package com.springboot.blog.Mapper;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;

import java.util.stream.Collectors;

public class PostMapper {

    // convert post to map postDto
    public static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .content(post.getContent())
                .comments(post.getComments().stream()
                        .map(CommentMapper::mapToCommentDto)
                        .collect(Collectors.toSet()))
                .build();
    }

    // convert PostDto to map Post
    public static Post mapToPost(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .description(postDto.getDescription())
                .content(postDto.getContent())
                .build();
    }
}
