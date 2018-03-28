package com.example.amy.to_do_list.Models;

import java.io.Serializable;

/**
 * Created by Amy on 26/03/2018.
 */

public class Task implements Serializable {
    public String taskName;
    public String description;
    public boolean completion;
    public Integer ID;

    public Task (String taskName, String description, boolean completion) {
        this.taskName = taskName;
        this.description = description;
        this.completion = completion;
    }


    public Task (String taskName, String description, boolean completion, Integer ID) {
        this.taskName = taskName;
        this.description = description;
        this.completion = completion;
        this.ID = ID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean getCompletionStatus() {
        return this.completion;
    }
}
