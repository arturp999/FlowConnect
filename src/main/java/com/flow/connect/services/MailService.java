package com.flow.connect.services;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.flow.connect.configurations.mail.MailConfigurations;
import com.flow.connect.configurations.mail.MailProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {

    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    private final MailConfigurations mailConfigurations;

    public JavaMailSender getMailSender(String configurationKey) {
	logger.debug("Getting mail sender for configuration key: {}", configurationKey);

	// Get the configuration for the given key
	MailProperties config = mailConfigurations.getConfigurations().get(configurationKey);

	if (config == null) {
	    logger.error("No mail configuration found for key: {}", configurationKey);
	    throw new IllegalArgumentException("No mail configuration found for key: " + configurationKey);
	}

	// Configure JavaMailSender with properties from MailProperties
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	mailSender.setHost(config.getHost());
	mailSender.setPort(config.getPort());
	mailSender.setUsername(config.getUsername());
	mailSender.setPassword(config.getPassword());

	// Set additional properties if available
	Properties props = mailSender.getJavaMailProperties();
	if (config.getProperties() != null) {
	    props.putAll(config.getProperties());
	}

	logger.info("Mail sender configured for host: {}", config.getHost());
	return mailSender;
    }

    public void sendMail(String configurationKey, String to, String subject, String body, String cc) {
	logger.info("Sending email to: {}, subject: {}, CC: {}", to, subject, cc);

	try {
	    // Get the mail sender for the specified configuration
	    JavaMailSender mailSender = getMailSender(configurationKey);

	    // Create a simple mail message
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo(to); // Recipient's email address
	    message.setSubject(subject); // Email subject
	    message.setText(body); // Email body

	    // Set CC recipients if provided
	    if (cc != null && !cc.isEmpty()) {
		message.setCc(cc.split(","));
	    }

	    // Send the email
	    mailSender.send(message);
	    logger.info("Email sent successfully to: {}", to);
	} catch (Exception e) {
	    logger.error("Error sending email to: {}", to, e);
	}
    }
}
