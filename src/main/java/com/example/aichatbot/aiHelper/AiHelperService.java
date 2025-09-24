package com.example.aichatbot.aiHelper;

import dev.langchain4j.service.SystemMessage;

public interface AiHelperService {
//    @SystemMessage(fromResource = "sys_prompt.txt")
    String chat(String userMessage);
}
