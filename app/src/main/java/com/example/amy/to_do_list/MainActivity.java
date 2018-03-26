package com.example.amy.to_do_list;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
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

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.add_task:
                        Toast.makeText(MainActivity.this, "Task Added", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });


//        db.save(task);
//        db.allTasks();
    }
}
