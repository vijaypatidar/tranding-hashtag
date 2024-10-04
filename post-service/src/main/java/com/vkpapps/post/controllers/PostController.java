package com.vkpapps.post.controllers;

import com.vkpapps.post.dtos.CreatePostRequest;
import com.vkpapps.post.dtos.CreatePostResponse;
import com.vkpapps.post.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping
    public CreatePostResponse create(CreatePostRequest request) {
        return postService.create(request);
    }
}
