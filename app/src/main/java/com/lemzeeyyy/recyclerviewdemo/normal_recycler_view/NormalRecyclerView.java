package com.lemzeeyyy.recyclerviewdemo.normal_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.lemzeeyyy.recyclerviewdemo.R;

import java.util.ArrayList;

public class NormalRecyclerView extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Planet> planetArrayList;
    private PlanetAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_recycler_view);
        recyclerView = findViewById(R.id.normal_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        planetArrayList = new ArrayList<>();
        adapter = new PlanetAdapter(this,planetArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        createListData();
        Log.d("Planet", "onCreate: Size: "+planetArrayList.size());
    }

    private void createListData() {
        Planet planet = new Planet("Earth", 150,10,12750);
        planetArrayList.add(planet);

        // Adding some other info
        planet = new Planet("Jupiter", 778, 26, 143000);
        planetArrayList.add(planet);
        planet = new Planet("Mars", 228, 4, 6800);
        planetArrayList.add(planet);
        planet = new Planet("Pluto", 5900, 1, 2320);
        planetArrayList.add(planet);
        planet = new Planet("Venus", 108, 9, 12750);
        planetArrayList.add(planet);
        planet = new Planet("Saturn", 1429, 11, 120000);
        planetArrayList.add(planet);
        planet = new Planet("Mercury", 58, 4, 4900);
        planetArrayList.add(planet);
        planet = new Planet("Neptune", 4500, 12, 50500);
        planetArrayList.add(planet);
        planet = new Planet("Uranus", 2870, 9, 52400);
        planetArrayList.add(planet);

        adapter.notifyDataSetChanged();
    }
}