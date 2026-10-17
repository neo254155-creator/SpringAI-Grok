package com.first.genProject.service;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.chatEntity;

@Service
public class AIServiceImpl implements AiService {

    private final ChatClient chatClient;

    public AIServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    @Override
    public chatEntity chat(String query) {
    	Prompt prompt=new Prompt(query);
    	String Sys="Act as a Java Full Stack developer:{query}";
    	
        var chat= chatClient
        		.prompt(query)
        		.user(u->u.text(Sys).param("query", query))
                .call()
                .entity(chatEntity.class);
        return chat;
    }
    public String ChatTemplate() {
    	PromptTemplate pt=PromptTemplate.builder().template("What do you mean by {TechStack}? explain me with {example}").build();
    	String render=pt.render(Map.of("TechStack","Spring","example","code"));
      Prompt p=new Prompt (render);
      return this.chatClient.prompt(p).call().content();
}
}
