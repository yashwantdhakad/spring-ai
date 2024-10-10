package com.example.demo.service;

import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    @Autowired
    OllamaChatModel chatModel;

    public String getResponse(String query) {
        String template = """
                 Please provide me details of this {query}
                """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        promptTemplate.add("query", query);

        Prompt prompt = promptTemplate.create();

        return chatModel.call(prompt).getResult().getOutput().getContent();
    }
}
