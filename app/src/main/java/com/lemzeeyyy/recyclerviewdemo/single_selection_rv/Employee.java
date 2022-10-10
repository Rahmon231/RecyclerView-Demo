package com.lemzeeyyy.recyclerviewdemo.single_selection_rv;

import java.io.Serializable;

public class Employee implements Serializable {
    private Boolean isChecked = false;
    private String name;


    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
