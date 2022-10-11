package com.lemzeeyyy.recyclerviewdemo.multiple_selection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.lemzeeyyy.recyclerviewdemo.R;
import com.lemzeeyyy.recyclerviewdemo.single_selection_rv.Employee;

import java.util.ArrayList;

public class MultipleSelectionActivity extends AppCompatActivity {
    private MultipleAdapter adapter;
    private ArrayList<Employee> employees;
    private Button btn;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_selection);
        btn = findViewById(R.id.get_multiple_selection_btn);
        recyclerView = findViewById(R.id.multiple_rv);
    }
}