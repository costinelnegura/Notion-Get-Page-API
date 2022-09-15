package com.costinel.notionGetPage.notion.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("notion")
public record NotionConfigProperties(String apiURL, String apiVersion, String secretToken, String databaseId) {
}
