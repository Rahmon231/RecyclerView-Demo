package com.lemzeeyyy.recyclerviewdemo.swipe_recycler_view;

import android.content.Context;

import com.lemzeeyyy.recyclerviewdemo.single_selection_rv.Employee;


import java.util.ArrayList;

public class SwipeRecyclerAdapter {
    private Context context;
    private ArrayList<Employee> employees;
   // private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();




    public SwipeRecyclerAdapter(Context context, ArrayList<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }
}
