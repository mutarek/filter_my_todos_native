package com.example.filtermytodos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.filtermytodos.adapters.Spinner_Adapters;
import com.example.filtermytodos.adapters.TodoAdapter;
import com.example.filtermytodos.models.Todos;
import com.example.filtermytodos.models.users;
import com.example.filtermytodos.viewmodels.TodoViewModel;
import com.example.filtermytodos.viewmodels.User_list_viewmodel;

import java.util.List;
import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    List<users> myuser;
    User_list_viewmodel user_list_viewmodel;
    Spinner spinner;
    private  List<Todos> todos;
    private TodoAdapter todoAdapter;
    private TodoViewModel todoViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setIint();
        setUserViewModel();
        setTodoViewModel();
        setTodoLayoutManage();
    }

    private void setIint() {
        spinner = findViewById(R.id.spinner);
        recyclerView =findViewById(R.id.recylleView);
    }


    private void setTodoLayoutManage() {
        LinearLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        todoAdapter = new TodoAdapter(this,todos);
        recyclerView.setAdapter(todoAdapter);
    }

    private void setUserViewModel() {
        user_list_viewmodel = ViewModelProviders.of(this).get(User_list_viewmodel.class);
        user_list_viewmodel.getUserListObserver().observe(this, new Observer<List<users>>() {
            @Override
            public void onChanged(List<users> usersList) {
                myuser = usersList;
                Spinner_Adapters custom_adapter = new Spinner_Adapters(MainActivity.this,R.layout.sample_layout,users.getUserArrayList());
                spinner.setAdapter(custom_adapter);
            }
        });
        user_list_viewmodel.makeApiCall();
    }

    private void setTodoViewModel() {
        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel.class);
        todoViewModel.getTodolistObserver().observe(this, new Observer<List<Todos>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(List<Todos> todoslist) {
                if (todoslist !=null)
                {
                    sortModels(todoslist);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        todoViewModel.maketodoapicall();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void sortModels(List<Todos> todoslists) {
        todos = todoslists;
        todoAdapter.setTodoList(todoslists);
    }
}