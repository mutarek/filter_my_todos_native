package com.example.filtermytodos.models;

import java.util.ArrayList;

public class users {

    private static  ArrayList<users> usersArrayList = new ArrayList<>();

    int id;
    String name;

    public users() {
    }

    public users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static  ArrayList<users> getUserArrayList(){
        return usersArrayList;
    }
}
