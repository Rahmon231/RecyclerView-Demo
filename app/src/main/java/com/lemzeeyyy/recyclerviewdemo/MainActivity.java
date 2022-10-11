package com.lemzeeyyy.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lemzeeyyy.recyclerviewdemo.card_recycler_view.CardRecyclerView;
import com.lemzeeyyy.recyclerviewdemo.multiple_selection.MultipleSelectionActivity;
import com.lemzeeyyy.recyclerviewdemo.normal_recycler_view.NormalRecyclerView;
import com.lemzeeyyy.recyclerviewdemo.single_selection_rv.SingleSelectionRV;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.normal_rec_btn);
        btn2 = findViewById(R.id.card_rec_btn);
        btn3 = findViewById(R.id.single_selection_btn);
        btn4 = findViewById(R.id.multiple_sel_btn);
       btn1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,NormalRecyclerView.class)));
        btn2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, CardRecyclerView.class)));
        btn3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, SingleSelectionRV.class)));
        btn4.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MultipleSelectionActivity.class)));
    }

}