package com.example.aichatbot.aiHelper;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.UserName;
import reactor.core.publisher.Flux;

public interface AiHelperService {
//    @SystemMessage(fromResource = "sys_prompt.txt")
    String chat(String userMessage);

    @SystemMessage(fromResource = "sys_prompt.txt")
    Flux<String> chatStreaming(@MemoryId String memoryId, @UserMessage String message);
}
