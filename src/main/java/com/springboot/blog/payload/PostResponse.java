package com.springboot.blog.payload;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private List<PostDto> content;
    private int pageNo;
    private int PageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
