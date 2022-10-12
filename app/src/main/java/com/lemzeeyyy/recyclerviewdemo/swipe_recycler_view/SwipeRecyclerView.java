package com.lemzeeyyy.recyclerviewdemo.swipe_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lemzeeyyy.recyclerviewdemo.R;

public class SwipeRecyclerView extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_recycler_view);
    }
}