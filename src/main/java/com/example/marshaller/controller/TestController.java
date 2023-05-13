package com.example.marshaller.controller;

import com.example.marshaller.model.DemoResponse;
import com.example.marshaller.model.DummyMessage2;
import com.example.marshaller.model.DummyMessage1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final MessageChannel messageChannel;

    @PostMapping(path = "/mvc")
    public ResponseEntity<DummyMessage1> post(@RequestBody DummyMessage1 dummyMessage) {
        return ResponseEntity.ok(dummyMessage);
    }

    @PostMapping(path = "/message")
    public ResponseEntity<DemoResponse> postDummyMessage(@RequestBody DummyMessage2 dummyMessage2) {
        MessageBuilder<DummyMessage2> messageBuilder = MessageBuilder
                .withPayload(dummyMessage2)
                .setHeader("dummyHeaderKey", "dummyHeaderValue");
        messageChannel.send(messageBuilder.build());
        return ResponseEntity.ok(DemoResponse.builder().build());
    }
}
