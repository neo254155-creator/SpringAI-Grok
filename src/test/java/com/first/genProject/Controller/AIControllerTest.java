package com.first.genProject.Controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.first.genProject.service.AiService;

import entity.chatEntity;

class AIControllerTest {

    @Test
    void chatPassesQueryToServiceAndReturnsResponse() throws Exception {
        AiService aiService = mock(AiService.class);
        when(aiService.chat("hello")).thenReturn(new chatEntity("title", "response", "2026"));
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new AIController(aiService)).build();

        mockMvc.perform(get("/chat").param("q", "hello"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"title":"title","content":"response","createdYear":"2026"}
                        """));

        verify(aiService).chat("hello");
    }
}
