package com.example.webtestclientsse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SSEController {

    @GetMapping(path = "/", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter createEmitter() {
        SseEmitter emitter = new SseEmitter(3600000L);
        emitter.onTimeout(() -> {
            emitter.complete();
        });
        return emitter;
    }
}
