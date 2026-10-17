package com.first.genProject.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatOptionsConfig {

	@Bean
	public ChatClient chatClient (ChatClient.Builder builder) {
		return builder
				.defaultOptions(OpenAiChatOptions.builder()
				
				.temperature(0.2)
				.maxTokens(100)
				).build();
	}
	
}
