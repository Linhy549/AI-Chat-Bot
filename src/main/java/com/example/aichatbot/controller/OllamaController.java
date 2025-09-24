package com.example.aichatbot.controller;

import com.example.aichatbot.aiHelper.AppointmentService;
import com.example.aichatbot.model.Appointment;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.ollama.OllamaChatModel;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {

    @Resource
    OllamaChatModel ollamaChatModel;

    @Resource
    AppointmentService appointmentService;

    @GetMapping("/model/chat")
    public String chat(@RequestParam(value = "message", defaultValue = "你好") String message){
        //http://localhost:8080/model/chat?message=%E4%BD%A0%E6%98%AF%E8%B0%81
        ChatRequest request = ChatRequest.builder()
                .messages(UserMessage.userMessage(TextContent.from(message)))
                .build();
        ChatResponse chat = ollamaChatModel.chat(request);
        return chat.aiMessage().text();
    }

    @GetMapping("/model/email")
    public boolean book() {

        // Example: create appointment directly
        Appointment appointment = new Appointment("John Doe", "john@example.com", "2025-09-25 15:00");
        appointmentService.bookAppointment(appointment);

        return true;
    }
}