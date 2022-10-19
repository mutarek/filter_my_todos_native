package com.example.filtermytodos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.filtermytodos.R;
import com.example.filtermytodos.models.users;

import java.util.List;

public class Spinner_Adapters extends ArrayAdapter<users> {

    LayoutInflater layoutInflater;

    public Spinner_Adapters(@NonNull Context context, int resource, @NonNull List<users> user) {
        super(context, resource, user);
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View rootview = layoutInflater.inflate(R.layout.sample_layout,null,false);
        users users = getItem(position);
        TextView textView = rootview.findViewById(R.id.text);
        textView.setText(users.getName());
        return rootview;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView ==null) convertView = layoutInflater.inflate(R.layout.sample_layout,parent,true);
        users users = getItem(position);
        TextView textView = convertView.findViewById(R.id.text);
        textView.setText(users.getName());
        return convertView;

    }
}
