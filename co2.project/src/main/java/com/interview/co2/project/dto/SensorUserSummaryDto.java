package com.interview.co2.project.dto;

public class SensorUserSummaryDto {

    private Long id;

    private String username;

    private String city;

    public SensorUserSummaryDto(Long id, String username, String city) {
        this.id = id;
        this.username = username;
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
