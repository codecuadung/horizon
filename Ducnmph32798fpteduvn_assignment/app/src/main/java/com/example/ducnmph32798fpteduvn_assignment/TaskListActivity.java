package com.example.ducnmph32798fpteduvn_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;



public class TaskListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        recyclerView = findViewById(R.id.recyclerView);

        // Initialize the task list
        taskList = new ArrayList<>();
        // Add tasks to the list (you can replace this with your actual task data)
        taskList.add(new Task("Task 1", "In Progress", "2022-01-01", "2022-01-05"));
        taskList.add(new Task("Task 2", "Completed", "2022-01-06", "2022-01-10"));
        taskList.add(new Task("Task 3", "Pending", "2022-01-11", "2022-01-15"));

        // Initialize the task adapter
        taskAdapter = new TaskAdapter(taskList);

        // Set the RecyclerView layout manager and adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(taskAdapter);
    }
}