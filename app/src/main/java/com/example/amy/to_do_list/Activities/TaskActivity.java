package com.example.amy.to_do_list.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amy.to_do_list.Db.Helpers.TaskDbHelper;
import com.example.amy.to_do_list.R;
import com.example.amy.to_do_list.Models.Task;

public class TaskActivity extends AppCompatActivity {
    TextView taskName, taskDetails;
    Button deleteButton, editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();
        Task selectedTask = (Task) intent.getSerializableExtra("task");

        taskName = findViewById(R.id.taskName);

        String name = selectedTask.getTaskName();
        taskName.setText(name);

        taskDetails = findViewById(R.id.taskDetails);
        String details = selectedTask.getDescription();
        taskDetails.setText(details);
    }
    public void onDeleteButtonClick(View view) {

        String name = taskName.getText().toString();
        String description = taskDetails.getText().toString();

        Task task = new Task(name, description, false);

        TaskDbHelper dbHelper = new TaskDbHelper(this);
        dbHelper.delete(task);

        Toast.makeText(TaskActivity.this,"Task Deleted",Toast.LENGTH_SHORT).

                show();

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
