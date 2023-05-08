package com.springboot.blog.mapper;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;

import java.util.stream.Collectors;

public class PostMapper {

    // postDto map to post
    public static Post mapToPost(PostDto postDto) {
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .description(postDto.getDescription())
                .content(postDto.getContent())
                .comments(postDto.getComments() == null ? null : postDto.getComments()
                        .stream().map(CommentMapper::mapToComment)
                        .collect(Collectors.toSet()))
                .build();
    }

    // post map to postDtp
    public static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .content(post.getContent())
                .comments(post.getComments() == null ? null : post.getComments()
                        .stream().map(CommentMapper::mapToCommentDto)
                        .collect(Collectors.toSet()))
                .categoryId(post.getCategory() == null ? null : post.getCategory().getId())
                .build();
    }
}
