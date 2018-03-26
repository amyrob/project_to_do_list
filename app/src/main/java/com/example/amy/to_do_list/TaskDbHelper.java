package com.example.amy.to_do_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amy on 26/03/2018.
 */

public class TaskDbHelper extends DbHelper {
    public TaskDbHelper(Context context) {
        super(context);
    }

    public void save(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TaskContract.COLUMN_NAME_TASK, task.taskName);
        values.put(TaskContract.COLUMN_NAME_COMPLETION_STATUS, task.completion);

        db.insert(TaskContract.TABLE_NAME, null, values);
    }

    public List<Task> allTasks() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TaskContract.TABLE_NAME, null, null, null, null, null, null);

        List allTasks = new ArrayList<>();
        while(cursor.moveToNext()) {
            int newTask = cursor.getInt(
                    cursor.getColumnIndexOrThrow(TaskContract._ID));
            allTasks.add(newTask);
        }
        cursor.close();
        return allTasks;
    }
}

