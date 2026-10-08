package com.first.genProject.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;

@Service
public class AIServiceImpl implements AiService {

    private final ChatClient chatClient;

    public AIServiceImpl(OpenAiChatModel chatModel) {
        this.chatClient = ChatClient.create(chatModel);
    }

    @Override
    public String chat(String query) {
        return chatClient.prompt()
                .system("Act as an HR of a multinational company")
                .user(query)
                .call()
                .content();
    }
}
