package com.example.amy.to_do_list;

import java.io.Serializable;

/**
 * Created by Amy on 26/03/2018.
 */

public class Task implements Serializable {
    public String taskName;
    public boolean completion;

    public Task (String taskName, boolean completion) {
        this.taskName = taskName;
        this.completion = completion;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public boolean getCompletionStatus() {
        return this.completion;
    }

}
