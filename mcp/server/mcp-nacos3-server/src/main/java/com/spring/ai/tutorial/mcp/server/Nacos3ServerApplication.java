package com.spring.ai.tutorial.mcp.server;

import com.spring.ai.tutorial.mcp.server.service.TimeService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author yingzi
 * @date 2025/6/4 16:39
 */
@SpringBootApplication
public class Nacos3ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Nacos3ServerApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider timeTools(TimeService timeService) {
        return MethodToolCallbackProvider.builder().toolObjects(timeService).build();
    }
}
