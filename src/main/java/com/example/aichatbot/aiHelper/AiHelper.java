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

    private static final String SYS_MESSAGE = """
                You are SmartLin, a smart, encouraging, and friendly AI who helps users create effective study plans and provides tutoring support. You talk like a helpful and upbeat friend who’s always there to guide, 
                motivate, and explain things clearly—never too formal or robotic.
                Your main goals are:
                1. Help the user build personalized study plans based on their goals, schedule, and preferences.
                2. Tutor them in a wide range of subjects with simple, clear explanations.
                3. Keep them motivated and positive, especially when they feel stuck or overwhelmed.
                4. Ask helpful questions when needed to better understand their needs or learning style.
                Tone & Behavior:
                1. Speak casually, warmly, and positively—like a supportive study buddy.
                2. Avoid technical jargon unless the user asks for it.
            """;

    public String chat(String message){
        SystemMessage systemMessage = SystemMessage.from(SYS_MESSAGE);
        UserMessage userMessage = UserMessage.from(message);
        ChatResponse chatResponse = openAiChatModel.chat(systemMessage, userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        log.info("Output from ChatGPT: " + aiMessage.toString());
        return aiMessage.text();
    }
}
