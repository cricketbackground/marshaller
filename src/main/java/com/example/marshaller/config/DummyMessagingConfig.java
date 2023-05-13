package com.example.marshaller.config;

import com.example.marshaller.service.DummyMessageProducerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

@Configuration
public class DummyMessagingConfig {

    @Bean
    public MessageChannel messageChannel() {
        return MessageChannels.direct("messageChannel").get();
    }

    @Bean
    public IntegrationFlow integrationFlow(DummyMessageProducerService dummyMessageProducerService) {
        return IntegrationFlow.from("messageChannel")
                .handle(dummyMessageProducerService, "callThisDummyMethod")
                .get();
    }

}
