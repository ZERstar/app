 package com.example.vital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.vital.adaptor.ToDoAdaptor;
import com.example.vital.model.ToDoModel;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    private RecyclerView tasksRecyclerView;
    private ToDoAdaptor tasksAdapter;

    private List<ToDoModel>taskList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        taskList = new ArrayList<>();

        tasksRecyclerView = findViewById(R.id.tasksRecyclerview);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ToDoAdaptor(this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        ToDoModel task = new ToDoModel();
        task.setTask("This is a Test Task");
        task.setStatus(0);
        task.setId(1);

        taskList.add(task);
        taskList.add(task);
        taskList.add(task);
        taskList.add(task);
        taskList.add(task);
        taskList.add(task);

        tasksAdapter.setTasks(taskList);

    }
}