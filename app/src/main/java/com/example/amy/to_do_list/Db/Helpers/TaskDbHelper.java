package com.example.amy.to_do_list.Db.Helpers;

//**

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.amy.to_do_list.Activities.AddTaskActivity;
import com.example.amy.to_do_list.Db.Contracts.TaskContract;
import com.example.amy.to_do_list.Models.Task;

import java.util.ArrayList;

public class TaskDbHelper extends DbHelper {
    public TaskDbHelper(Context context) {
        super(context);
    }

    public void save(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TaskContract.COLUMN_NAME_TASK, task.getTaskName());
        values.put(TaskContract.COLUMN_NAME_DESCRIPTION, task.getDescription());
        values.put(TaskContract.COLUMN_NAME_COMPLETION_STATUS, task.getCompletionStatus());

        long result = db.insert(TaskContract.TABLE_NAME, null, values);

        Log.e("blah", "Result: " + result);

        db.close();
    }

        public ArrayList<Task> allTasks() {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TaskContract.TABLE_NAME, null);


            ArrayList<Task> allTasks = new ArrayList<>();
            while(cursor.moveToNext()) {
                int taskId = cursor.getInt(
                        cursor.getColumnIndexOrThrow(TaskContract._ID));
                String name = cursor.getString(
                        cursor.getColumnIndexOrThrow(TaskContract.COLUMN_NAME_TASK)
                );
                String details = cursor.getString(
                        cursor.getColumnIndexOrThrow(TaskContract.COLUMN_NAME_DESCRIPTION)
                );

                int completed = cursor.getInt(
                        cursor.getColumnIndexOrThrow(TaskContract.COLUMN_NAME_COMPLETION_STATUS)
                );

                boolean complete = completed == 1;

                Task task = new Task(name, details, complete, taskId);
                allTasks.add(task);
            }
            cursor.close();
            return allTasks;
        }
}
