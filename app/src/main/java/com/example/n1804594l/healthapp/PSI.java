package com.example.se_project;

import android.location.Location;
/**
 * The PSI class, used to demonstrate the imformation about PSI
 */
public class PSI {
    private String name;
    private double latitude;
    private double longitude;
    private double psi_twenty_four_hourly;

    /**
     * Create a PSIobject
     * @param message A <code>name, longitude, latitude, PSI_one_hourly</code> for this object
     */
    public PSI(String name, double longitude,double latitude,double PSI_one_hourly){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.psi_twenty_four_hourly = PSI_one_hourly;
    }

    /**
     * Get the imformation about name
     * @return the name
     */
    public String getName(){
        String name2 = new String(name);
        return name2;
    }

    /**
     * Get the imformation about latitude
     * @return the latitude
     */
    public double getLatitude(){
        return latitude;
    }

    /**
     * Get the imformation about longitude
     * @return the longitude
     */
    public double getLongitude(){
        return longitude;
    }
    /**
     * Get the imformation about 24-hour PSI
     * @return the value of 24-hour PSI
     */
    public double getPSI_one_hourly(){
        return psi_twenty_four_hourly;
    }

    /**
     * Get the distance between places
     * @param message A <code>latitude,longitude</code> for this object
     * @return the value of distance
     */
    public float distance (double latitude,double longitude){
        float[] results = new float[1];
        Location.distanceBetween(this.latitude, this.longitude,
                latitude, longitude,
                results);
        return results[0];
    }
/*
    //debug
    public void print(){
        System.out.println("name: "+name + " " + "lat: " + latitude + " "+ "long: " + longitude+ " " + "PSI: " + psi_twenty_four_hourly);
    }*/
}
