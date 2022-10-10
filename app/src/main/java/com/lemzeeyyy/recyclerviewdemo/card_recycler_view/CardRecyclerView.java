package com.lemzeeyyy.recyclerviewdemo.card_recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.lemzeeyyy.recyclerviewdemo.R;

import java.util.ArrayList;

public class CardRecyclerView extends AppCompatActivity {
    private ArrayList<PlanetsCards> planetsArrayList;
    private PlanetCardAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recycler_view);
        recyclerView = findViewById(R.id.recyclerView_card);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        planetsArrayList = new ArrayList<>();
        adapter = new PlanetCardAdapter(this,planetsArrayList);
        recyclerView.setAdapter(adapter);
        createDataForCards();


    }
    private void createDataForCards() {
        // This Method is for adding the data to recyclerView
        // let's make adapter and planet model class

        PlanetsCards planet = new PlanetsCards("Earth", 150,10,12750);
        planetsArrayList.add(planet);

        // Adding some other info
        planet = new PlanetsCards("Jupiter", 778, 26, 143000);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Mars", 228, 4, 6800);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Pluto", 5900, 1, 2320);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Venus", 108, 9, 12750);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Saturn", 1429, 11, 120000);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Mercury", 58, 4, 4900);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Neptune", 4500, 12, 50500);
        planetsArrayList.add(planet);
        planet = new PlanetsCards("Uranus", 2870, 9, 52400);
        planetsArrayList.add(planet);

        adapter.notifyDataSetChanged();



    }
}