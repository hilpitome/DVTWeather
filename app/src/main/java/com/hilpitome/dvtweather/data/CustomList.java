package com.hilpitome.dvtweather.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CustomList {

    @SerializedName("dt")
    @Expose
    private Integer dt;

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("weather")
    @Expose
    private Weather weather = null;

    @SerializedName("clouds")
    @Expose
    private Clouds clouds;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    @SerializedName("visibility")
    @Expose
    private Integer visibility;

    @SerializedName("pop")
    @Expose
    private int pop;

    @SerializedName("rain")
    @Expose
    private Rain rain;

    @SerializedName("sys")
    @Expose
    private Sys sys;

    @SerializedName("dt_text")
    @Expose
    private String dtText;

}
