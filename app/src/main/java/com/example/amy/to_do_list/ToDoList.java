package com.example.amy.to_do_list;

import java.util.ArrayList;

/**
 * Created by Amy on 26/03/2018.
 */

public class ToDoList {
    private ArrayList<Task> list;

    public ToDoList() {
        list = new ArrayList<Task>();
        list.add(new Task ("Put stuff on Ebay", false));
    }

    public ArrayList<Task> getList() {
        return new ArrayList<Task>(list);
    }
}
