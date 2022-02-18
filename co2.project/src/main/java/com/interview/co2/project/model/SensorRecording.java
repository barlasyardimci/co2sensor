package com.interview.co2.project.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sensorRecording")
public class SensorRecording {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long recordId;

    @ManyToOne
    @JoinColumn(name = "sensorLocation")
    private SensorLocation sensorLocation;

    @Column(name = "recordTime")
    @CreationTimestamp
    private Date recordTime;

    @Column(name = "co2Level")
    private double co2Level;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public SensorLocation getSensorLocation() {
        return sensorLocation;
    }

    public void setSensorLocation(SensorLocation sensorLocation) {
        this.sensorLocation = sensorLocation;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public double getCo2Level() {
        return co2Level;
    }

    public void setCo2Level(double co2Level) {
        this.co2Level = co2Level;
    }
}
