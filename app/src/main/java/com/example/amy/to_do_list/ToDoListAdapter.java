package com.example.amy.to_do_list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Amy on 26/03/2018.
 */

public class ToDoListAdapter extends ArrayAdapter<Task> {
    public ToDoListAdapter(Context context, ArrayList<Task> list) {
        super(context, 0, list);
    }
    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        Task currentTask = getItem(position);
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent, false);
        }
        TextView task_name = listItemView.findViewById(R.id.task_name);
        task_name.setText(currentTask.getTaskName().toString());

        CheckBox completed_status = listItemView.findViewById(R.id.completed_status);
        completed_status.setTag(currentTask.getCompletionStatus());

        listItemView.setTag(currentTask);
        return listItemView;
    }
}
