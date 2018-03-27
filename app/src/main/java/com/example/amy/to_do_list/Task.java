package com.example.amy.to_do_list;

import java.io.Serializable;

/**
 * Created by Amy on 26/03/2018.
 */

public class Task implements Serializable {
    public String taskName;
    public String description;
    public boolean completion;

    public Task (String taskName, String description, boolean completion) {
        this.taskName = taskName;
        this.description = description;
        this.completion = completion;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean getCompletionStatus() {
        return this.completion;
    }

}
