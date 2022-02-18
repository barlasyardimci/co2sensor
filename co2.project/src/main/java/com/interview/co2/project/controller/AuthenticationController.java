package com.interview.co2.project.controller;

import com.interview.co2.project.dto.LoginRequestDto;
import com.interview.co2.project.dto.SensorUserSummaryDto;
import com.interview.co2.project.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/signup")
    public ResponseEntity<SensorUserSummaryDto> signUp(@RequestBody LoginRequestDto loginRequestDto){

        return ResponseEntity.ok(authenticationService.signup(loginRequestDto));

    }


}
