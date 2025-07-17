package com.example.aichatbot;

import com.example.aichatbot.aiHelper.AiHelper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AiChatBotApplicationTests {

    @Resource
    private AiHelper aiHelper;
    @Test
    void chat() {
        aiHelper.chat("Hey there! who are you?");
    }

}
