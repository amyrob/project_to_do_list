package com.example.amy.to_do_list.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amy.to_do_list.Db.Helpers.TaskDbHelper;
import com.example.amy.to_do_list.Models.Task;
import com.example.amy.to_do_list.R;

public class AddTaskActivity extends AppCompatActivity {
    EditText taskName, details;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        taskName = (EditText) findViewById(R.id.addNewTask);
        details = (EditText) findViewById(R.id.newTaskDetails);
    }

    public void onAddButtonClick(View view) {
        String name = taskName.getText().toString();
        String description = details.getText().toString();

        Task task = new Task(name, description, false);

        TaskDbHelper dbHelper = new TaskDbHelper(this);
        dbHelper.save(task);

        Toast.makeText(AddTaskActivity.this, "Task Saved", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
