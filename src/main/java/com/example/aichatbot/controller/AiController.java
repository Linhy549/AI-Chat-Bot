package com.example.aichatbot.controller;

import com.example.aichatbot.aiHelper.AiHelperService;
import jakarta.annotation.Resource;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiHelperService aiHelperService;

    @GetMapping("/chat")
    public Flux<ServerSentEvent<String>> chat(String memoryId, String message) {

        return aiHelperService.chatStreaming(memoryId, message)
                .map(chunk -> ServerSentEvent.<String>builder()
                        .data(chunk)
                        .build());
    }
}
