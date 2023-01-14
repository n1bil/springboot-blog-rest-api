package com.springboot.blog.PostMapper;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;

public class PostMapper {

    // convert post to map postDto
    public static PostDto mapToPostDto(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .content(post.getContent())
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
