package com.example.amy.to_do_list.Db.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.*;
import android.util.Log;

import com.example.amy.to_do_list.Activities.AddTaskActivity;
import com.example.amy.to_do_list.Db.Contracts.TaskContract;

/**
 * Created by Amy on 26/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 9;
    private static final String DATABASE_NAME = "todolist.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("blah", TaskContract.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(TaskContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.e("blah", "drop it");
        sqLiteDatabase.execSQL(TaskContract.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}


