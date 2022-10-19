package com.example.filtermytodos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filtermytodos.R;
import com.example.filtermytodos.models.Todos;

import org.w3c.dom.Text;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private Context context;
    private List<Todos> todosList;

    public TodoAdapter(Context context, List<Todos> todosList) {
        this.context = context;
        this.todosList = todosList;
    }
    public void  setTodoList(List<Todos> todos){
        this.todosList = todos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dummy_layout,parent,false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.title.setText(todosList.get(position).getTitle().toString());
        holder.userid.setText("Posted By: "+String.valueOf(todosList.get(position).getUserId()));
        holder.id.setText("Todo No"+String.valueOf(todosList.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        if (todosList !=null)
        {
            return todosList.size();
        }
        else return 0;
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        TextView title,userid,id;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.todo_title);
            userid = itemView.findViewById(R.id.todo_user_id);
            id = itemView.findViewById(R.id.todo_id);
        }
    }
}
