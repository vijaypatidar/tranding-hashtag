package com.vkpapps.post.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vkpapps.post.dtos.CreatePostRequest;
import com.vkpapps.post.dtos.CreatePostResponse;
import com.vkpapps.post.models.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {
    private final KafkaService kafkaService;

    public CreatePostResponse create(CreatePostRequest request) {
        String key = UUID.randomUUID().toString();
        Post post = new Post(key, request.content(), request.tags(), new Date());
        kafkaService.send("posts", key, post);
        return new CreatePostResponse(key);
    }
}
