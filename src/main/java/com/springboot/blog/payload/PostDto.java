package com.springboot.blog.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
@Builder
public class PostDto {

    private long id;

    // title should not be null or empty
    // title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title must have at least 2 charters")
    private String title;

    // post description should not be null or empty
    // post description should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description must have at least 10 characters")
    private String description;

    // post content must not be null or empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comments;
}
