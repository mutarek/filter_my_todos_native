package com.example.filtermytodos.apis;


import com.example.filtermytodos.models.Todos;
import com.example.filtermytodos.models.users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("users")
    Call<List<users>> getAllUsers();

    @GET("todos/")
    Call<List<Todos>> getAllTodos();
}
