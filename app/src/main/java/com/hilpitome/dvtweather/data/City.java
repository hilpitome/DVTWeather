package com.hilpitome.dvtweather.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("coord")
    @Expose
    private Coord coord;

    @SerializedName("population")
    @Expose
    private int population;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("timezone")
    @Expose
    private int timezone;

    @SerializedName("sunrise")
    @Expose
    private long sunrise;

    @SerializedName("sunset")
    @Expose
    private long sunset;


}
