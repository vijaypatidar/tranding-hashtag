package com.vkpapps.post.dtos;

import java.util.List;

public record CreatePostRequest(
        String content,
        List<String> tags
) {
}
