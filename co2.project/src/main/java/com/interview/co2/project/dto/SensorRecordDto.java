package com.interview.co2.project.dto;

public class SensorRecordDto {

    private String city;
    private String district;
    private double co2level;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getCo2level() {
        return co2level;
    }

    public void setCo2level(Long co2level) {
        this.co2level = co2level;
    }
}
