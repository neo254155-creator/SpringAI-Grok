package com.first.genProject.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

import entity.chatEntity;

@Service
public class AIServiceImpl implements AiService {

    private final ChatClient chatClient;

    public AIServiceImpl(OpenAiChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    @Override
    public chatEntity chat(String query) {
        return chatClient.prompt(query)
                .system("Act as an HR of a multinational company")
                .call()
                .entity(chatEntity.class);
    }
}
