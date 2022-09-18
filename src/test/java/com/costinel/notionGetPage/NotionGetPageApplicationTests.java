package com.costinel.notionGetPage;

import com.costinel.notionGetPage.model.Email;
import com.costinel.notionGetPage.notion.NotionClient;
import com.costinel.notionGetPage.notion.config.NotionConfigProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class NotionGetPageApplicationTests {

    @Autowired
    NotionClient notionClient;

    @Autowired
    NotionConfigProperties notionConfigProperties;

    /*
    Run this test after you declare the following as environment variables in your IDE!!!
    notion.database-id=<your notion database ID>
    notion.secret-token=<your notion secret token>
     */
    @Test
    public void itShouldReturnStatus200_OK() {
        //given
        List<Email> emailList = new ArrayList<>();
        ResponseEntity<List<Email>> expectedResponseEntity = new ResponseEntity<>(emailList, HttpStatus.OK);

        //when
        ResponseEntity<List<Email>> testedResponseEntity =
                notionClient.databases.queryDatabase(notionConfigProperties.databaseId());

        //then
        Assertions.assertEquals(expectedResponseEntity.getStatusCode(), testedResponseEntity.getStatusCode());
    }
}
