package com.spring.ai.tutorial.advisor.controller;

import com.spring.ai.tutorial.advisor.component.ReasoningContentAdvisor;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author yingzi
 * @date 2025/5/21 10:11
 */

@RestController
@RequestMapping("/advisor/chat")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultAdvisors(
                        new ReasoningContentAdvisor(0)
                )
                .build();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamChat(@RequestParam(value = "query", defaultValue = "你好，很高兴认识你，能简单介绍一下自己吗？")String query, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        return chatClient.prompt(query).stream().content();
    }
}