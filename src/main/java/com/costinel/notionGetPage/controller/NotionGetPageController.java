package com.costinel.notionGetPage.controller;

import com.costinel.notionGetPage.model.Email;
import com.costinel.notionGetPage.notion.NotionClient;
import com.costinel.notionGetPage.notion.config.NotionConfigProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotionGetPageController {
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
    public ResponseEntity<List<Email>> getNotionPages() {
        return notionClient.databases.queryDatabase(notionConfigProperties.databaseId());
    }
}