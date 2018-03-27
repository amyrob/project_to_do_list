package com.example.amy.to_do_list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {
    EditText taskName, details;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        taskName = (EditText) findViewById(R.id.addNewTask);
        details = (EditText) findViewById(R.id.newTaskDetails);

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onAddButtonClick();
                Toast.makeText(AddTaskActivity.this, "Task Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getTaskName() {
        return taskName.getText().toString();
    }

    public String getDescription() {
        return details.getText().toString();
    }

    public void onAddButtonClick() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
