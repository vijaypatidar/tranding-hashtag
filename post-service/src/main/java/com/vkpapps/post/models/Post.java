package com.vkpapps.post.models;

import java.util.List;

public record Post(
        String id,
        String content,
        List<String> tags,
        java.util.Date postTime) {
}
