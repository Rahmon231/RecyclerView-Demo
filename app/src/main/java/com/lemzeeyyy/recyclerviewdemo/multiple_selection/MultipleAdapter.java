package com.lemzeeyyy.recyclerviewdemo.multiple_selection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemzeeyyy.recyclerviewdemo.R;
import com.lemzeeyyy.recyclerviewdemo.single_selection_rv.Employee;

import java.util.ArrayList;

public class MultipleAdapter extends RecyclerView.Adapter<MultipleAdapter.MultipleViewHolder> {
    private Context context;
    private ArrayList<Employee> employees;

    public MultipleAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public MultipleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee,parent,false);
        return new MultipleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultipleViewHolder holder, int position) {
        holder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class MultipleViewHolder extends RecyclerView.ViewHolder {
        private TextView empName;
        private ImageView tickImage;
        public MultipleViewHolder(@NonNull View itemView) {
            super(itemView);
            empName = itemView.findViewById(R.id.emp_name);
            tickImage = itemView.findViewById(R.id.imageviewy);
        }
        void bind(Employee employee){
            tickImage.setVisibility(employee.getChecked()?View.VISIBLE : View.GONE);
            empName.setText(employee.getName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    employee.setChecked(!employee.getChecked());
                    tickImage.setVisibility(employee.getChecked()?View.VISIBLE : View.GONE);
                }
            });
        }
    }
    public ArrayList<Employee> getSelected(){
        ArrayList<Employee> selected = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getChecked()){
                selected.add(employees.get(i));
            }
        }
        return selected;
    }
    public ArrayList<Employee> getAllEmployees(){
        return employees;
    }
    public void setEmployees(ArrayList<Employee> employees){
        this.employees = new ArrayList<>();
        this.employees = employees;
        notifyDataSetChanged();
    }
}
