# Notion Get Page API
### API developed in Java that retrieves pages from a Notion database.
The retrieved pages are emails that were imported from Outlook.


---
Because each Notion Database has its own ID, you have to add that property in the command line when executing 
the project.

`--notion.secret-token=type your token here` 

`--notion.database-id=type your notion database id here`

---
### Port

`server.port=8300`

---

### API Endpoint

###### GET: `http://localhost:8300/get-notion-pages`

---
### What is returned
The API return a list of pages from a Notion database with the ID's of the following properties:

```
{
  "id": "notion page ID",
  "taskNameId": "title",
  "highPriorityId": "%3FLVu",
  "dueDateId": "vxSj",
  "claimIdId": "G%5D%7CT",
  "statusId": "%7BRSk",
  "contextId": "LlrK",
  "emailFromId": "aW%40%7C",
  "emailToId": "_%3CxA",
  "emailCcId": "%7CiL%7B",
  "createdId": "%7Cr%7Cm",
  "editedId": "%60%3C%7C%3F"
}
```

The reasoning of this implementation is that Notion returns only the properties ID's, then these properties can be 
queried if needed.

---