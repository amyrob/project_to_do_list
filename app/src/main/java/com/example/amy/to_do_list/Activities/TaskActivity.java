package com.example.amy.to_do_list.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.amy.to_do_list.R;
import com.example.amy.to_do_list.Models.Task;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();
        Task selectedTask = (Task) intent.getSerializableExtra("task");
    }
}
