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
    private List<Weather> weather;

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
    private double pop;

    @SerializedName("rain")
    @Expose
    private Rain rain;

    @SerializedName("sys")
    @Expose
    private Sys sys;

    @SerializedName("dt_text")
    @Expose
    private String dtText;

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDtText() {
        return dtText;
    }

    public void setDtText(String dtText) {
        this.dtText = dtText;
    }
}
