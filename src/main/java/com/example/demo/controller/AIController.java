package com.example.demo.controller;

import com.example.demo.service.AIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AIController {
    @Autowired
    AIService aiService;

    @PostMapping("/chat")
    public String getQueryResponse(@RequestParam String query) {
        return aiService.getResponse(query);
    }

}
