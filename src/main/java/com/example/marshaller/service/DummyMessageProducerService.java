package com.example.marshaller.service;

import com.example.marshaller.model.DummyMessage2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record DummyMessageProducerService(StreamBridge streamBridge) {

    /**
     * This method is configured in IntegrationFlow and will be called whenever message is sent to channel messageChannel
     *
     * @param dummyHeaderValue - dummy header
     * @param dummyMessage2     - dummy message
     */
    public void callThisDummyMethod(@Header(name = "dummyHeaderKey") String dummyHeaderValue,
                                    @Payload DummyMessage2 dummyMessage2) {
        log.info("Got payload = {}, header = {}", dummyMessage2, dummyHeaderValue);
        log.info("Sending dummy message = {}", dummyMessage2);
        streamBridge.send("foo-in-0", dummyMessage2);
    }
}
