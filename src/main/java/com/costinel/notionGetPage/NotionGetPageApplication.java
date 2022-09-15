package com.costinel.notionGetPage;

import com.costinel.notionGetPage.notion.config.NotionConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NotionConfigProperties.class)
public class NotionGetPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotionGetPageApplication.class, args);
    }

}
