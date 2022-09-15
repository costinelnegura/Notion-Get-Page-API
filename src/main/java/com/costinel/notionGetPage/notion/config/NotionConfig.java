package com.costinel.notionGetPage.notion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class NotionConfig {

    @Bean
    public WebClient getWebClientBuilder(){

        return   WebClient.builder().exchangeStrategies(ExchangeStrategies.builder()

                        .codecs(configurer -> configurer

                                .defaultCodecs()

                                .maxInMemorySize(16 * 1024 * 1024))

                        .build())

                .build();

    }
}
