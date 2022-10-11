package com.lemzeeyyy.recyclerviewdemo.multiple_selection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        employees = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL));
        adapter = new MultipleAdapter(this,employees);
        recyclerView.setAdapter(adapter);
        CreateListOfData();
        Log.d("CheckEmployee", "onCreate: "+employees.size());
        btn.setOnClickListener(v -> {
            if(adapter.getSelected().size() > 0){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < adapter.getSelected().size() ; i++) {
                    stringBuilder.append(adapter.getSelected().get(i).getName());
                    stringBuilder.append("\n");
                }

                ShowToast(stringBuilder.toString().trim());
            }else
            ShowToast("No Selection");
        });
    }
    private void CreateListOfData() {
        employees = new ArrayList<>();

        for (int i = 0; i < 20 ; i++){
            Employee employee = new Employee();
            employee.setName("Employee " + (i+1));

            // Showing at least one selection
            if (i == 0 ){
                employee.setChecked(true);
            }

            employees.add(employee);
        }
        adapter.setEmployees(employees);

    }

    private void ShowToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}