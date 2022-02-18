package com.interview.co2.project.repository;

import com.interview.co2.project.model.SensorUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorUserRepository extends JpaRepository<SensorUser, Long> {

    SensorUser findByUsername(String username);

    SensorUser findByCity(String city);

    SensorUser findByUsernameAndCity(String username, String city);

}
