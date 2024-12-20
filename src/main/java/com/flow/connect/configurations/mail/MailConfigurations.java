package com.flow.connect.configurations.mail;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;

@Component
@ConfigurationProperties(prefix = "spring.mail")
@Data
@Builder
public class MailConfigurations {

    private Map<String, MailProperties> configurations;

}
