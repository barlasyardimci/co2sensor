package com.interview.co2.project.service;

import com.interview.co2.project.dto.LoginRequestDto;
import com.interview.co2.project.dto.SensorUserSummaryDto;
import com.interview.co2.project.model.SensorUser;
import com.interview.co2.project.repository.SensorUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class AuthenticationService {


    @Autowired
    SensorUserRepository sensorUserRepository;

    public SensorUserSummaryDto signup(LoginRequestDto loginRequestDto){

        SensorUser user = sensorUserRepository.findByCity(loginRequestDto.getUsername());

        if(Objects.nonNull(user)) return new SensorUserSummaryDto(user.getId(),user.getUsername(), user.getCity());

        SensorUser newUser = new SensorUser();
        newUser.setUsername(loginRequestDto.getUsername());
        newUser.setCity(loginRequestDto.getCity());
        newUser.setPassword(loginRequestDto.getPassword());
        newUser = sensorUserRepository.save(newUser);

        return new SensorUserSummaryDto(newUser.getId(),newUser.getUsername(), newUser.getCity());

    }


}
