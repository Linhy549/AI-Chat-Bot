package com.example.aichatbot.aiHelper;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiHelperServiceFactory {
    @Resource
    private ChatModel openAiChatModel;

    @Resource
    private ChatModel ollamaChatModel;

    @Bean
    public AiHelperService aiHelperService(){
        return AiServices.create(AiHelperService.class, ollamaChatModel);
    }
}
