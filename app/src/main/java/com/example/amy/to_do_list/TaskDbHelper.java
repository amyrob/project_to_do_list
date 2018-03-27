package com.example.amy.to_do_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Amy on 26/03/2018.
 */

public class TaskDbHelper extends DbHelper {
    public TaskDbHelper(Context context) {
        super(context);
    }

    public void save(AddTaskActivity task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TaskContract.COLUMN_NAME_TASK, task.getTaskName());
        values.put(TaskContract.COLUMN_NAME_DESCRIPTION, task.getDescription());
//        values.put(TaskContract.COLUMN_NAME_COMPLETION_STATUS, getCompletionStatus());

        db.insert(TaskContract.TABLE_NAME, null, values);
        db.close();
    }

//    public List<Task> allTasks() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.query(TaskContract.TABLE_NAME, null, null, null, null, null, null);
//
//        List allTasks = new ArrayList<>();
//        while(cursor.moveToNext()) {
//            int newTask = cursor.getInt(
//                    cursor.getColumnIndexOrThrow(TaskContract._ID));
//            allTasks.add(newTask);
//        }
//        cursor.close();
//        return allTasks;
//    }
}

