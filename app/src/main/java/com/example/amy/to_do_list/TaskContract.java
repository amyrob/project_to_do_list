package com.example.amy.to_do_list;

import android.provider.BaseColumns;
import android.util.EventLogTags;

/**
 * Created by Amy on 26/03/2018.
 */

public class TaskContract implements BaseColumns {
    private TaskContract(){}

    public static final String TABLE_NAME = "ToDoList";
    public  static final String COLUMN_NAME_TASK = "TaskName";
    public static final String COLUMN_NAME_DESCRIPTION = "Description";
    public static final String COLUMN_NAME_COMPLETION_STATUS = "Complete";

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_TASK + " TEXT," +
                    COLUMN_NAME_DESCRIPTION + "TEXT" +
                    COLUMN_NAME_COMPLETION_STATUS + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

}

