package com.lemzeeyyy.recyclerviewdemo.card_recycler_view;

public class PlanetsCards {
    private String planetName;
    private int distanceFromSun;
    private int diameter;
    private int gravity;

    public PlanetsCards(String planetName, int distanceFromSun, int gravity, int diameter) {
        this.planetName = planetName;
        this.distanceFromSun = distanceFromSun;
        this.diameter = diameter;
        this.gravity = gravity;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(int distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }
}
