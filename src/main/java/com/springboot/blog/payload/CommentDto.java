package com.springboot.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {

    private long id;

    // name must not be null or empty
    @NotEmpty(message = "Name must not be null or empty")
    private String name;

    // email must not be null or empty
    // email fiend validation
    @NotEmpty(message = "Email must not be null or empty")
    @Email(message = "Must be a well-formed email address")
    private String email;

    // comment message must not be null or empty
    // comment message must be minimum 10 characters
    @NotEmpty
    @Size(min = 10, message = "Comment message must me minimum 10 characters")
    private String message;
}
