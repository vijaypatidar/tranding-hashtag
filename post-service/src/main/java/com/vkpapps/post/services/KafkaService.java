package com.vkpapps.post.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void send(String topic, String key, Object message) {
        String data = null;
        try {
            data = objectMapper.writeValueAsString(message);
            CompletableFuture<SendResult<String, String>> posts = kafkaTemplate.send("posts", key, data);
        } catch (JsonProcessingException ignored) {

        }
    }
}
