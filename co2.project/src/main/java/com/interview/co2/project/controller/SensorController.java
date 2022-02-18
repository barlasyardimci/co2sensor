package com.interview.co2.project.controller;

import com.interview.co2.project.dto.LoginRequestDto;
import com.interview.co2.project.dto.SensorRecordDto;
import com.interview.co2.project.dto.SensorRequestDto;
import com.interview.co2.project.model.SensorLocation;
import com.interview.co2.project.model.SensorRecording;
import com.interview.co2.project.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    SensorService sensorService;

    @PostMapping("/getLatestRecord")
    public ResponseEntity<SensorRecording> getLatestRecording(@RequestBody SensorRequestDto sensorRequestDto) throws Exception {

        return ResponseEntity.ok(sensorService.getLatestRecord(sensorRequestDto));

    }

    @PostMapping("/getRecordHistory")
    public ResponseEntity<List<SensorRecording>> getRecordingHistory(@RequestBody SensorRequestDto sensorRequestDto) throws Exception {

        return ResponseEntity.ok(sensorService.getRecordingHistory(sensorRequestDto));

    }

    @PostMapping("/setupSensor")
    public ResponseEntity<SensorLocation> setupSensor(@RequestBody SensorRequestDto sensorRequestDto) throws Exception {

        return ResponseEntity.ok(sensorService.setupSensor(sensorRequestDto));

    }

    @PostMapping("/saveRecord")
    public ResponseEntity<SensorRecording> saveRecord(@RequestBody SensorRecordDto sensorRecordDto) throws Exception {

        return ResponseEntity.ok(sensorService.saveRecord(sensorRecordDto));

    }


}
