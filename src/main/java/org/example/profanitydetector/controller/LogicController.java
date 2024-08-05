package org.example.profanitydetector.controller;

import org.example.profanitydetector.service.LogicService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LogicController {
    private final LogicService logicService;

    public LogicController(LogicService logicService) {
        this.logicService = logicService;
    }

    @GetMapping("/check")
    public String checkMessage(@RequestParam String message) {
        return this.logicService.getAnswer(message);
    }
}
