package com.lemzeeyyy.recyclerviewdemo.normal_recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemzeeyyy.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.Locale;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder> {
    private Context context;
    private ArrayList<Planet> planets;

    public PlanetAdapter(Context context, ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }

    @NonNull
    @Override
    public PlanetAdapter.PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.planet_layout_item,
                parent,false);

        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetAdapter.PlanetViewHolder holder, int position) {
        Planet planet = planets.get(position);
        holder.SetDetails(planet);
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public class PlanetViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName, txtDistance, txtGravity, txtDiameter;


        public PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtDistance = itemView.findViewById(R.id.txtDistance);
            txtGravity = itemView.findViewById(R.id.txtGravity);
            txtDiameter = itemView.findViewById(R.id.txtDiameter);
        }
        void SetDetails(Planet planet){
            txtName.setText(planet.getPlanetName());
            txtDistance.setText(String.format(Locale.US,
                    "Distance from sun : %d Million KM", planet.getDistanceFromSun()));
            txtGravity.setText(String.format(Locale.US,
                    "Surface Gravity : %d N/Kg", planet.getGravity()));
            txtDiameter.setText(String.format(Locale.US,
                    "Diamter : %d KM", planet.getDiameter()));
        }
    }
}
