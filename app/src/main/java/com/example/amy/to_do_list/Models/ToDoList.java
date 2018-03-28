package com.example.amy.to_do_list.Models;

import com.example.amy.to_do_list.Models.Task;

import java.util.ArrayList;

/**
 * Created by Amy on 26/03/2018.
 */

public class ToDoList {
    private ArrayList<Task> list;

    public ToDoList() {
        list = new ArrayList<Task>();
        list.add(new Task ("Put stuff on Ebay", "Boots, Ski's, Poles", false));
    }

    public ArrayList<Task> getList() {
        return new ArrayList<Task>(list);
    }
}
