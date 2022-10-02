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
Notion Database fields:

![Notion Database fields](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/dc836e0f-d029-4ed3-98bf-37d6cc2b0f73/Screenshot_2022-10-02_at_13.47.15.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221002%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221002T125037Z&X-Amz-Expires=86400&X-Amz-Signature=eb5e1d841635425471e3fcca5ea6e7085413e351abc2eb6a9ae6c723e124318a&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Screenshot%25202022-10-02%2520at%252013.47.15.png%22&x-id=GetObject)
