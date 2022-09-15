package com.costinel.notionGetPage.model;

public record Email(String id,
                    String taskNameId,
                    String highPriorityId,
                    String dueDateId,
                    String claimIdId,
                    String statusId,
                    String contextId,
                    String emailFromId,
                    String emailToId,
                    String emailCcId,
                    String createdId,
                    String editedId
                    ) {
}
