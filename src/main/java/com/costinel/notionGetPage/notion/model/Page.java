package com.costinel.notionGetPage.notion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDateTime;

public class Page {

    private String object;

    @JsonProperty("id")
    private String id;

    @JsonProperty("created_time")
    private LocalDateTime created_time;

    @JsonProperty("last_edited_time")
    private LocalDateTime last_edited_time;

    @JsonProperty("parent.database_id")
    private String parent;

    @JsonProperty("archived")
    private Boolean archived;

    @JsonProperty("url")
    private String url;

    @JsonProperty("properties")
    private JsonNode properties;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public LocalDateTime getLast_edited_time() {
        return last_edited_time;
    }

    public void setLast_edited_time(LocalDateTime last_edited_time) {
        this.last_edited_time = last_edited_time;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JsonNode getProperties() {
        return properties;
    }

    public void setProperties(JsonNode properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Page{" +
                "object='" + object + '\'' +
                ", id='" + id + '\'' +
                ", created_time=" + created_time +
                ", last_edited_time=" + last_edited_time +
                ", parent='" + parent + '\'' +
                ", archived=" + archived +
                ", url='" + url + '\'' +
                ", properties=" + properties +
                '}';
    }
}
