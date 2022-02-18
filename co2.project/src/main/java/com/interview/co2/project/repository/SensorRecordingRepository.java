package com.interview.co2.project.repository;

import com.interview.co2.project.model.SensorLocation;
import com.interview.co2.project.model.SensorRecording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRecordingRepository extends JpaRepository<SensorRecording, Long> {

    List<SensorRecording> findBySensorLocation(SensorLocation sensorLocation);

    @Query("select s1 from SensorRecording s1 where s1.sensorLocation = ?1 order by s1.recordTime desc")
    List<SensorRecording> findBySensorLocationDescByTime(SensorLocation sensorLocation);

}