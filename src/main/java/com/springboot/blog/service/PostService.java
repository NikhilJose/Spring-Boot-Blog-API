package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.payload.PostResponse;

public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPost(long id);

    PostDto updatePost(long id, PostDto postDto);

    void deletePost(long id);
}
