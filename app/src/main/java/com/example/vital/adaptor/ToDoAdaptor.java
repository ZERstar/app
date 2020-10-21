package com.example.vital.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.recyclerview.widget.RecyclerView;

import com.example.vital.MainActivity;
import com.example.vital.R;
import com.example.vital.model.ToDoModel;

import java.util.List;

public class ToDoAdaptor extends RecyclerView.Adapter<ToDoAdaptor.ViewHolder> {

    private List<ToDoModel>  toDoModelList;
    private MainActivity activity;

    public ToDoAdaptor(MainActivity activity){
        this.activity = activity;
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        ToDoModel item = toDoModelList.get(position);
        holder.task.setText(item.getTask());
        holder.task.setChecked(toBoolean(item.getStatus()));
    }
    public int getItemCount() {
        return toDoModelList.size();
    }

    private boolean toBoolean(int n){
        return n!=0;

    }

    public void setTasks(List<ToDoModel> todolist){
        this.toDoModelList = todolist;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
       CheckBox task;

       ViewHolder(View view){
           super(view);
           task = view.findViewById(R.id.taskCheckBox);
        }
    }
}
