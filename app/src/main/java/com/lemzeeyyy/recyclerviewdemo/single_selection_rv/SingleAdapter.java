package com.lemzeeyyy.recyclerviewdemo.single_selection_rv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemzeeyyy.recyclerviewdemo.R;

import java.util.ArrayList;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.SingleViewHolder> {
    private Context context;
    private ArrayList<Employee> employees;
    private int checkedPosition = 0;


    public SingleAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public SingleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee,parent,false);
        return new SingleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SingleViewHolder holder, int position) {
        holder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class SingleViewHolder extends RecyclerView.ViewHolder {
        private TextView empName;
        private ImageView tickImage;
        public SingleViewHolder(@NonNull View itemView) {
            super(itemView);
            empName = itemView.findViewById(R.id.emp_name);
            tickImage = itemView.findViewById(R.id.imageviewy);
        }


        void bind(final Employee employee){
            if (checkedPosition == -1){
                empName.setVisibility(View.GONE);
            }else{
                if (checkedPosition == getAdapterPosition()){
                    tickImage.setVisibility(View.VISIBLE);
                }
                else{
                    tickImage.setVisibility(View.GONE);
                }
            }

            empName.setText(employee.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tickImage.setVisibility(View.VISIBLE);
                    if (checkedPosition != getAdapterPosition()){
                        notifyItemChanged(checkedPosition);
                        checkedPosition = getAdapterPosition();
                    }

                }
            });
        }

    }
    public void SetEmployees(ArrayList<Employee> employees){
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }

    public Employee getSelected(){
        if (checkedPosition != -1){
            return employees.get(checkedPosition);
        }
        return null;
    }
    public int getPosition(){
        return checkedPosition;
    }

}
