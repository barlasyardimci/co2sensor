package com.interview.co2.project.repository;

import com.interview.co2.project.model.SensorLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<SensorLocation, Long> {

    List<SensorLocation> findByCity(String city);

    SensorLocation findByCityAndDistrict(String city, String district);

    boolean existsByCityAndDistrict(String city, String district);

}
