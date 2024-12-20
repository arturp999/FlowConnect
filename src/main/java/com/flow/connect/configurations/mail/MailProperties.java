package com.flow.connect.configurations.mail;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailProperties {
    
    private String host;
    
    private int port;
    
    private String username;
    
    private String password;
    
    private Map<String, String> properties;

}
