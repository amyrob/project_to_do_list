package com.example.amy.to_do_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToDoList toDoList= new ToDoList();
        ArrayList<Task> list = toDoList.getList();

        ToDoListAdapter toDoListAdapter = new ToDoListAdapter(this, list);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(toDoListAdapter);

        TaskDbHelper db = new TaskDbHelper(this);
        db.getWritableDatabase();
//
//
//        db.save(task);
//        db.allTasks();
    }
}
