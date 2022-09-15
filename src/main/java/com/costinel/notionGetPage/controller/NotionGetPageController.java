package com.costinel.notionGetPage.controller;

import com.costinel.notionGetPage.model.Email;
import com.costinel.notionGetPage.notion.NotionClient;
import com.costinel.notionGetPage.notion.config.NotionConfigProperties;
import com.costinel.notionGetPage.notion.model.Page;
import com.costinel.notionGetPage.notion.service.DatabaseService;
import com.costinel.notionGetPage.service.NotionGetPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotionGetPageController {
    private final Logger log = LoggerFactory.getLogger(DatabaseService.class);
    private final NotionClient notionClient;
    private final NotionConfigProperties notionConfigProperties;

    public NotionGetPageController(NotionClient notionClient, NotionConfigProperties notionConfigProperties) {
        this.notionClient = notionClient;
        this.notionConfigProperties = notionConfigProperties;
    }

    /*
    This Method uses the GetMapping annotation to send a request to a Notion database.
    The response will be saved as a List of type Pages with all the pages on the Notion database.

    http://localhost:<port>/get-notion-pages

     */
    @GetMapping("/get-notion-pages")
    public List<Email> getNotionPages() {
        List<Page> pages = notionClient.databases.queryDatabase(notionConfigProperties.databaseId());
        log.info("List of pages retrieve: {}", pages);
        return pages.stream()
                .map(NotionGetPageService::getAllEmailPropertyIds)
                .peek(System.out::println)
                .toList();
    }
}