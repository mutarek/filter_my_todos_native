package com.example.filtermytodos.viewmodels;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.filtermytodos.MainActivity;
import com.example.filtermytodos.apis.APIService;
import com.example.filtermytodos.apis.RetrofitInstance;
import com.example.filtermytodos.models.users;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class User_list_viewmodel extends ViewModel {
    private MutableLiveData<List<users>> userlist;

    public User_list_viewmodel(){
        userlist = new MutableLiveData<>();
    }

    public MutableLiveData<List<users>> getUserListObserver(){
        return userlist;
    }

    public void makeApiCall(){
        APIService apiService = RetrofitInstance.getRetrofitClient().create(APIService.class);
        Call<List<users>> call = apiService.getAllUsers();

        call.enqueue(new Callback<List<users>>() {
            @Override
            public void onResponse(Call<List<users>> call, Response<List<users>> response) {
                userlist.postValue(response.body());
                Log.d("data",response.body().toString());
            }

            @Override
            public void onFailure(Call<List<users>> call, Throwable t) {
                Log.d("error",t.getMessage());
            }
        });
    }
}
