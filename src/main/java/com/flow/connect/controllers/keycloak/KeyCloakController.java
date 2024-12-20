package com.flow.connect.controllers.keycloak;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flow.connect.services.MailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/keycloak")
@RequiredArgsConstructor
public class KeyCloakController {
    
    //Will use this in the future for user registration/login/pw reset and other stuff

}
