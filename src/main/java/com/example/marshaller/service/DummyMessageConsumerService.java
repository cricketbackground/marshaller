package com.example.marshaller.service;

import com.example.marshaller.model.DummyMessage2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
@Slf4j
public record DummyMessageConsumerService(StreamBridge streamBridge) {

    @Bean
    public Consumer<DummyMessage2> foo() {
        return dummyMessage2 -> {
            log.info("Received dummy message = {}", dummyMessage2);
            streamBridge.send("foo-out-0", dummyMessage2);
        };
    }
}
