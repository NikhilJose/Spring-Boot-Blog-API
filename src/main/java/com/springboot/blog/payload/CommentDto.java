package com.springboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDto {

    private long id;
    @NotEmpty(message = "Name should not be null or empty")
    private String name;
    @NotEmpty(message = "Body should not be nul or empty")
    @Size(min = 10, message = "Body must be minimum 10 characters")
    private String body;
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;
}
