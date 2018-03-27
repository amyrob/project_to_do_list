package com.example.amy.to_do_list;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToDoList toDoList = new ToDoList();
        ArrayList<Task> list = toDoList.getList();

        ToDoListAdapter toDoListAdapter = new ToDoListAdapter(this, list);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(toDoListAdapter);

        TaskDbHelper db = new TaskDbHelper(this);
        db.getWritableDatabase();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_add);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add_task:
                        onNavBarAddClick();
                }
                return true;
            }
        });
    }

    public void onListItemClick(View listItem) {
        Task selectedTask = (Task) listItem.getTag();

        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("task", selectedTask);
        startActivity(intent);
    }

    public void onCheckBoxClick(View checkBox) {
        boolean checked = ((CheckBox)checkBox).isChecked();
        switch(checkBox.getId()) {
            case R.id.completed_status:
                if(checked)
                    Toast.makeText(MainActivity.this, "Awesome!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onNavBarAddClick() {
        Intent intent = new Intent(this, AddNewActivity.class);
        startActivity(intent);
    }

    }

//        db.save(task);
//        db.allTasks();

