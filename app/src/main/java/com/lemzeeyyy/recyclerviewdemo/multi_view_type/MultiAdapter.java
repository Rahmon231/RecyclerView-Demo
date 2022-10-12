package com.lemzeeyyy.recyclerviewdemo.multi_view_type;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lemzeeyyy.recyclerviewdemo.R;
import com.lemzeeyyy.recyclerviewdemo.single_selection_rv.Employee;

import java.util.ArrayList;

public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static int TYPE_CALL = 1;
    private static int TYPE_EMAIL = 2;
    private Context context;
    private ArrayList<MultiEmployee> employees;

    public MultiAdapter(Context context, ArrayList<MultiEmployee> employees) {
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == TYPE_CALL){
            // Display a call layout
            view = LayoutInflater.from(context).inflate(R.layout.item_call, parent,false);
            return new CallViewHolder(view);
        }else{
            // Display an email layout
            view = LayoutInflater.from(context).inflate(R.layout.item_email, parent,false);
            return new EmailViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_CALL) {
            ((CallViewHolder) holder).setCallDetails(employees.get(position));
        }


        else {
            ((EmailViewHolder) holder).setEmailDetails(employees.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }


    class EmailViewHolder extends RecyclerView.ViewHolder{

       private TextView txtName;
       private TextView txtAddress;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
           txtName = itemView.findViewById(R.id.txtName);
           txtAddress = itemView.findViewById(R.id.txtAddress);
        }
        void setEmailDetails(MultiEmployee employee){
            txtName.setText(employee.getName());
            txtAddress.setText(employee.getAddress());
        }
    }
    class CallViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName, txtAddress;

        public CallViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }
        void setCallDetails(MultiEmployee employee){
            txtName.setText(employee.getName());
            txtAddress.setText(employee.getAddress());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(TextUtils.isEmpty(employees.get(position).getEmail())){
            return TYPE_CALL;
        }else
            return TYPE_EMAIL;
    }
}
