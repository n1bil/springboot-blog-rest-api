package com.springboot.blog.payload;

import lombok.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {

    private Long id;

    // name should not be empty
    @NotEmpty(message = "Name must not be empty")
    private String name;

    // email should not be empty
    // email field validation
    @NotEmpty(message = "Email must not be empty")
    @Email
    private String email;

    // content should not be empty
    @NotEmpty(message = "content must not be empty")
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String content;
}
