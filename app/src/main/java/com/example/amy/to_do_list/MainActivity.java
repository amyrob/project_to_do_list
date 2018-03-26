package com.example.amy.to_do_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Task task = new Task("Check Ebay", false);

        TaskDbHelper db = new TaskDbHelper(this);

        db.save(task);
        db.allTasks();
    }
}
