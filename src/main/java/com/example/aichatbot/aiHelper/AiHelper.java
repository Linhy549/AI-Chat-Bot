package com.example.aichatbot.aiHelper;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AiHelper {
    @Resource
    private ChatModel openAiChatModel;

    public String chat(String message){
        UserMessage userMessage = UserMessage.from(message);
        ChatResponse chatResponse = openAiChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("Output from ChatGPT: " + aiMessage.toString());
        return aiMessage.text();
    }
}
