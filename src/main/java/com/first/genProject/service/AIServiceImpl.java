package com.first.genProject.service;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.core.io.Resource;

import entity.chatEntity;


@Service
public class AIServiceImpl implements AiService {

    private final ChatClient chatClient;
    @Value("classpath:/prompts/UserMessage")
    private Resource userMessage;

    @Value("classpath:/prompts/SystemMessage")
    private Resource systemMessage;
    
    public AIServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
//    @Override
//    public chatEntity chat(String query) {
//    	Prompt prompt=new Prompt(query);
//    	String Sys="Act as a Java Full Stack developer:{query}";
//    	
//        var chat= chatClient
//        		.prompt(query)
//        		.user(u->u.text(Sys).param("query", query))
//                .call()
//                .entity(chatEntity.class);
//        return chat;
//    }
    public String ChatTemplate() {
    	 var systemPromptTemplate=SystemPromptTemplate.builder()
              .resource(systemMessage)
              .build();
      var systemMessage=systemPromptTemplate.createMessage();

     var userPromptTemplate=PromptTemplate.builder().template("What is {techName}? tell ma also about {techExample}").build();
   var userMessage=userPromptTemplate.createMessage(Map.of(
           "techName", "Spring",
             "techExample", "spring exception"
     ));


      Prompt p= new Prompt(systemMessage,userMessage);
      return this.chatClient.prompt(p).call().content();
}
}
