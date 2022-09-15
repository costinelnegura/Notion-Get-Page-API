package com.costinel.notionGetPage.notion.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private String object;

    @JsonProperty("results")
    private List<Page> pages = new ArrayList<>();

    @JsonProperty("next_cursor")
    private String next_cursor;

    @JsonProperty("has_more")
    private Boolean has_more;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public String getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(String next_cursor) {
        this.next_cursor = next_cursor;
    }

    public Boolean getHas_more() {
        return has_more;
    }

    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }

    @Override
    public String toString() {
        return "Database{" +
                "object='" + object + '\'' +
                ", pages=" + pages +
                ", next_cursor=" + next_cursor +
                ", has_more=" + has_more +
                '}';
    }
}
