package com.interview.co2.project.model;


import javax.persistence.*;

@Entity
@Table(name = "SensorLocation")
public class SensorLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long sensorId;

    @Column(name = "district")
    private String district;

    @Column(name = "city")
    private String city;

    public SensorLocation(Long sensorId, String city, String district){
        this.sensorId = sensorId;
        this.city = city;
        this.district = district;
    }

    public SensorLocation(String city, String district){
        this.city = city;
        this.district = district;
    }

    public SensorLocation() {

    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "SensorLocation{" +
                "sensorId=" + sensorId +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SensorLocation)) return false;

        SensorLocation sensorLocation = (SensorLocation) o;

        if (!getSensorId().equals(sensorLocation.getSensorId())) return false;
        if (!getDistrict().equals(sensorLocation.getDistrict())) return false;
        return getCity().equals(sensorLocation.getCity());
    }

}
