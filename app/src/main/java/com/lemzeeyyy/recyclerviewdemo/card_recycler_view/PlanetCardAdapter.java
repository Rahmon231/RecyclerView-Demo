package com.lemzeeyyy.recyclerviewdemo.card_recycler_view;

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

public class PlanetCardAdapter extends RecyclerView.Adapter<PlanetCardAdapter.PlanetCardViewHolder> {
    private Context context;
    private ArrayList<PlanetsCards> planets;

    public PlanetCardAdapter(Context context, ArrayList<PlanetsCards> planets) {
        this.context = context;
        this.planets = planets;
    }

    @NonNull
    @Override
    public PlanetCardAdapter.PlanetCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card,parent,false);
        return new PlanetCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetCardAdapter.PlanetCardViewHolder holder, int position) {
        PlanetsCards planet = planets.get(position);
        holder.setDetails(planet);

    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public class PlanetCardViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNameCard, txtDistanceCard, txtGravityCard, txtDiameterCard;
        public PlanetCardViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameCard = itemView.findViewById(R.id.txtNameCard);
            txtDistanceCard = itemView.findViewById(R.id.txtDistanceCard);
            txtGravityCard = itemView.findViewById(R.id.txtGravityCard);
            txtDiameterCard = itemView.findViewById(R.id.txtDiameterCard);
        }

        public void setDetails(PlanetsCards planet) {
            txtNameCard.setText(planet.getPlanetName());
            txtDistanceCard.setText(String.format(Locale.US,
                    "Distance from sun : %d Million KM", planet.getDistanceFromSun()));
            txtGravityCard.setText(String.format(Locale.US,
                    "Surface Gravity : %d N/Kg", planet.getGravity()));
            txtDiameterCard.setText(String.format(Locale.US,
                    "Diamter : %d KM", planet.getDiameter()));
        }
    }
}
