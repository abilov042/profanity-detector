package org.example.profanitydetector.service;

import org.springframework.stereotype.Service;

@Service
public class LogicService {
    private final LlamaAIService llamaAIService;

    public LogicService(LlamaAIService llamaAIService) {
        this.llamaAIService = llamaAIService;
    }

    public String getAnswer(String message) {
        String res = llamaAIService.getResult(message);
        if(res.startsWith("1")){
            return "Shame of you.";
        }
        return "looks like good.";
    }
}
