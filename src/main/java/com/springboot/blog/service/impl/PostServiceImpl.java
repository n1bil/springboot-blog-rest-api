package com.springboot.blog.service.impl;

import com.springboot.blog.PostMapper.PostMapper;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<PostDto> getAllPosts(int pageNo, int pageSize) {
        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<Post> posts = postRepository.findAll(pageable);

        // get content for page object
        List<Post> listOfPages = posts.getContent();

        return listOfPages.stream()
                .map(PostMapper::mapToPostDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        return PostMapper.mapToPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        // get post by id from the database
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatePost = postRepository.save(post);

        return PostMapper.mapToPostDto(updatePost);
    }

    @Override
    public void deletePostById(Long postId) {
//        postRepository.deleteById(postId);
        // get post by id from the database
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        postRepository.delete(post);
    }

}
