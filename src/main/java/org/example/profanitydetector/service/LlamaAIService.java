package org.example.profanitydetector.service;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

@Service
public class LlamaAIService {
    private final OllamaChatModel chatModel;

    public LlamaAIService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResult(String prompt){
        ChatResponse chatResponse = chatModel.call(new Prompt(prompt, OllamaOptions.create().withModel("profanity-detector")));
        return chatResponse.getResult().getOutput().getContent();
    }
}
