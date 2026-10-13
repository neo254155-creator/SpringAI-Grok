package com.first.genProject.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.first.genProject.service.AiService;

import entity.chatEntity;

@RestController
@RequestMapping
public class AIController {

    private final AiService aiService;

    public AIController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping("/chat")
    public ResponseEntity<chatEntity> chat(@RequestParam("q") String q) {
        return ResponseEntity.ok(aiService.chat(q));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                .body("AI Provider Error: " + e.getMessage());
    }
}
