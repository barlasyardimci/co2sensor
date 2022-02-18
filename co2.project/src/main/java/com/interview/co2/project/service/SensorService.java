package com.interview.co2.project.service;

import com.interview.co2.project.dto.SensorDto;
import com.interview.co2.project.dto.SensorRecordDto;
import com.interview.co2.project.dto.SensorRequestDto;
import com.interview.co2.project.model.SensorLocation;
import com.interview.co2.project.model.SensorRecording;
import com.interview.co2.project.model.SensorUser;
import com.interview.co2.project.repository.SensorRecordingRepository;
import com.interview.co2.project.repository.SensorRepository;
import com.interview.co2.project.repository.SensorUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SensorService {

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    SensorRecordingRepository sensorRecordingRepository;

    @Autowired
    SensorUserRepository sensorUserRepository;

    public List<SensorLocation> getCityHistory(String city){
        List<SensorLocation> sensorLocationList = sensorRepository.findByCity(city);

        return sensorLocationList;
    }

    public SensorLocation setupSensor(SensorRequestDto sensorRequestDto) throws Exception {

        SensorUser user = sensorUserRepository.findByUsernameAndCity(sensorRequestDto.getUsername(), sensorRequestDto.getCity());
        if(Objects.isNull(user)) throw new Exception("no user found please try with a valid user");

        SensorLocation sensorLocation = sensorRepository.findByCityAndDistrict(sensorRequestDto.getCity(), sensorRequestDto.getDistrict());
        if(!Objects.isNull(sensorLocation)) throw new Exception("Sensor found");

        return sensorRepository.save(new SensorLocation(sensorRequestDto.getCity(), sensorRequestDto.getDistrict()));

    }

    public SensorRecording getLatestRecord(SensorRequestDto sensorRequestDto) throws Exception {

       SensorUser user = sensorUserRepository.findByUsernameAndCity(sensorRequestDto.getUsername(), sensorRequestDto.getCity());
       if(Objects.isNull(user)) throw new Exception("no user found please try with a valid user");

       SensorLocation sensorLocation = sensorRepository.findByCityAndDistrict(sensorRequestDto.getCity(), sensorRequestDto.getDistrict());
       if(Objects.isNull(sensorLocation)) throw new Exception("no sensor found in location");

       return sensorRecordingRepository.findBySensorLocationDescByTime(sensorLocation).get(0);

    }

    public List<SensorRecording> getRecordingHistory(SensorRequestDto sensorRequestDto) throws Exception {

        SensorUser user = sensorUserRepository.findByUsernameAndCity(sensorRequestDto.getUsername(), sensorRequestDto.getCity());
        if(Objects.isNull(user)) throw new Exception("no user found please try with a valid user");

        SensorLocation sensorLocation = sensorRepository.findByCityAndDistrict(sensorRequestDto.getCity(), sensorRequestDto.getDistrict());
        if(Objects.isNull(sensorLocation)) throw new Exception("no sensor found in location");

        return sensorRecordingRepository.findBySensorLocationDescByTime(sensorLocation);

    }

    public SensorRecording saveRecord(SensorRecordDto sensorRecordDto) throws Exception {
        SensorLocation sensorLocation = sensorRepository.findByCityAndDistrict(sensorRecordDto.getCity(), sensorRecordDto.getDistrict());
        if(Objects.isNull(sensorLocation)) throw new Exception("no sensor found in location");

        SensorRecording sensorRecording = new SensorRecording();
        sensorRecording.setSensorLocation(sensorLocation);
        sensorRecording.setCo2Level(sensorRecordDto.getCo2level());

        return sensorRecordingRepository.save(sensorRecording);

    }

}
