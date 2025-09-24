package com.example.aichatbot.aiHelper;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AiHelperServiceTest {
    @Resource
    private AiHelperService aiHelperService;
    @Test
    void chat() {
        String response = aiHelperService.chat("who are you?");
        log.info("Output from ChatGPT: " + response);

    }
}