package com.costinel.notionGetPage.service;

import com.costinel.notionGetPage.model.Email;
import com.costinel.notionGetPage.notion.model.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotionGetPageService {

    private static final Logger log = LoggerFactory.getLogger(NotionGetPageService.class);

    /*
    Method returning a new Email object by deconstructing a page object which is parsed as an argument and
    contains the Notion page properties.
     */
    public static Email getAllEmailPropertyIds(Page page) {
        log.info("getAllEmailPropertyIds method called passing Page object as argument: {}", page.toString());
        return new Email(
                page.getId(),
                page.getProperties().get("Task Description").get("id").textValue(),
                page.getProperties().get("High Priority").get("id").textValue(),
                page.getProperties().get("Due Date").get("id").textValue(),
                page.getProperties().get("Claim ID").get("id").textValue(),
                page.getProperties().get("Task Status").get("id").textValue(),
                page.getProperties().get("Context").get("id").textValue(),
                page.getProperties().get("Email From").get("id").textValue(),
                page.getProperties().get("Email To").get("id").textValue(),
                page.getProperties().get("Email CC").get("id").textValue(),
                page.getProperties().get("Created").get("id").textValue(),
                page.getProperties().get("Edited").get("id").textValue()
        );
    }
}
