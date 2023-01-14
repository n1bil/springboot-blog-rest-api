package com.springboot.blog.service.impl;

import com.springboot.blog.PostMapper.PostMapper;
import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = PostMapper.mapToPost(postDto);
        Post newPost = postRepository.save(post);
        return PostMapper.mapToPostDto(newPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

}
