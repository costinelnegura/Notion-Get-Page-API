package com.costinel.notionGetPage.notion.service;

import com.costinel.notionGetPage.model.Email;
import com.costinel.notionGetPage.notion.config.NotionConfigProperties;
import com.costinel.notionGetPage.notion.model.Database;
import com.costinel.notionGetPage.notion.model.Page;
import com.costinel.notionGetPage.service.NotionGetPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class DatabaseService {

    private final Logger log = LoggerFactory.getLogger(DatabaseService.class);
    private final NotionConfigProperties notionConfigProperties;
    private final WebClient.Builder builder;

    public DatabaseService(NotionConfigProperties notionConfigProperties, WebClient.Builder builder) {
        this.notionConfigProperties = notionConfigProperties;
        this.builder = builder;
    }

    /*
    Using the WebClient approach to query a notion database by its ID.
     */
    public ResponseEntity<List<Email>> queryDatabase(String databaseID) {
        var url = notionConfigProperties.apiURL() + "/v1/databases/" + databaseID + "/query";
        log.info("Querying Notion Database: {}", url);
        List<Email> emails = new ArrayList<>();
        try {
            List<Page> pages = Objects.requireNonNull(builder.build()
                            .post()
                            .uri(url)
                            .headers(httpHeaders -> {
                                httpHeaders.add("Notion-Version", notionConfigProperties.apiVersion());
                                httpHeaders.add("Authorization", notionConfigProperties.secretToken());
                            })
                            .accept(MediaType.APPLICATION_JSON)
                            .retrieve()
                            .bodyToFlux(Database.class)
                            .blockFirst())
                    .getPages();
            log.info("List of pages retrieve: {}", pages);
            emails = pages.stream()
                    .map(NotionGetPageService::getAllEmailPropertyIds)
                    .peek(System.out::println)
                    .toList();
            return new ResponseEntity<>(emails, HttpStatus.OK);
        }catch(WebClientResponseException e){
            log.error("Error: {}", e.getResponseBodyAsString());
            return new ResponseEntity<>(emails, e.getStatusCode());
        }
    }
}