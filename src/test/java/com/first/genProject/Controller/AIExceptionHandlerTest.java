package com.first.genProject.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class AIExceptionHandlerTest {

    @Test
    void mapsProviderAuthenticationFailuresToBadGateway() {
        AIController controller = new AIController(null);

        ResponseEntity<?> response = controller.handleAiProviderError(
                new NonTransientAiException("Invalid API key"));

        assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
        assertEquals("The AI provider rejected the request. Check the OPENAI_API_KEY configuration.",
                response.getBody());
    }
}
