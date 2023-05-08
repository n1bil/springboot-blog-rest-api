package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;
import com.springboot.blog.service.PostService;
import com.springboot.blog.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "CRUD Rest APIs for Post Resource")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post
    @Operation(summary = "Create Post REST API", description = "Create Post REST API is used to save post into database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        PostDto createdPost = postService.createPost(postDto);

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    // get all posts
//    @GetMapping
//    public ResponseEntity<List<PostDto>> getAllPosts() {
//        List<PostDto> posts = postService.getAllPosts();
//
//        return new ResponseEntity<>(posts, HttpStatus.OK);
//    }

    @Operation(summary = "Get All Posts REST API", description = "Get All Posts REST API is used to fetch all the posts from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping
    public ResponseEntity<PostResponse> getAllPostsBySizeNoSort(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir) {
        PostResponse posts = postService.getAllPostsBySizeNoSort(pageNo, pageSize, sortBy, sortDir);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // get post by id
    @Operation(summary = "Get Post By Id REST API", description = "Get Post By Id REST API is used to get single from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") Long postId) {
        PostDto postDto = postService.getPostById(postId);

        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    // update post by id rest api
    @Operation(summary = "Update Post REST API", description = "Update Post REST API is used to update a particular post in the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@Valid @RequestBody PostDto postDto,
                                                  @PathVariable("id") Long postId) {
        PostDto updatePost = postService.updatePostById(postDto, postId);

        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    // delete post rest api
    @Operation(summary = "Delete Post REST API", description = "Delete Post REST API is used to delete a particular post in the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @SecurityRequirement(name = "Bear Authentication")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable("id") Long id) {
        postService.deletePostById(id);

        return new ResponseEntity<>("Post entity was deleted successfully", HttpStatus.OK);
    }

    // Build get posts by category REST API
    // http://localhost:8080/api/posts/category/3

    @Operation(summary = "Get Posts By CategoryId REST API", description = "Get Posts By CategoryId REST API is used to get single from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("/category/{id}")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable("id") Long categoryId) {
        List<PostDto> posts = postService.getPostsByCategory(categoryId);

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

}
