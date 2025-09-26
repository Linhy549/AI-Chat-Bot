package com.example.aichatbot.aiHelper;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dev.langchain4j.rag.content.retriever.ContentRetriever;


@Configuration
public class AiHelperServiceFactory {
    @Resource
    private ChatModel openAiChatModel;

    @Resource
    private ChatModel ollamaChatModel;

    @Resource
    private StreamingChatModel ollamaStreamingChatModel;

    @Bean
    public AiHelperService aiHelperService(){

//        return AiServices.create(AiHelperService.class, ollamaChatModel);

        ChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(15);
        AiHelperService aiHelperService = AiServices.builder(AiHelperService.class)
                .chatModel(ollamaChatModel)
                .streamingChatModel(ollamaStreamingChatModel)
                .chatMemory(chatMemory)
                .chatMemoryProvider(memoryId ->
                        MessageWindowChatMemory.withMaxMessages(15))
                .build();
        return aiHelperService;
    }
}
