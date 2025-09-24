package com.example.aichatbot.aiHelper;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
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

    @Resource
    private ChatModel ollamaChatModel;

//    private static final String SYS_MESSAGE = "You are SmartLin, a smart, encouraging, and friendly AI";

    public String chat(String message){
//        SystemMessage systemMessage = SystemMessage.from(SYS_MESSAGE);
        UserMessage userMessage = UserMessage.from(message);
        ChatResponse chatResponse = ollamaChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
//        log.info("Output from ChatGPT: " + aiMessage.toString());
        return aiMessage.text();
    }
}
