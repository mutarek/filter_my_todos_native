package com.example.filtermytodos.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.filtermytodos.apis.APIService;
import com.example.filtermytodos.apis.RetrofitInstance;
import com.example.filtermytodos.models.Todos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoViewModel extends ViewModel {
    private MutableLiveData<List<Todos>> listMutableLiveData;
    public TodoViewModel() {
        listMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Todos>> getTodolistObserver(){
        return  listMutableLiveData;
    }

    public void maketodoapicall(){
        APIService apiService = RetrofitInstance.getRetrofitClient().create(APIService.class);
        Call<List<Todos>> call = apiService.getAllTodos();

        call.enqueue(new Callback<List<Todos>>() {
            @Override
            public void onResponse(Call<List<Todos>> call, Response<List<Todos>> response) {
                listMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Todos>> call, Throwable t) {
                listMutableLiveData.postValue(null);
            }
        });
    }
}
