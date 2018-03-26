package com.example.amy.to_do_list;

import android.content.Context;
import android.database.sqlite.*;
import android.os.Bundle;

/**
 * Created by Amy on 26/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "todolist.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TaskContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TaskContract.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
