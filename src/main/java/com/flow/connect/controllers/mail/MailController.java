package com.flow.connect.controllers.mail;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flow.connect.services.MailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @Operation(summary = "Send an email with optional CC", description = "Sends an email to a recipient with optional CC field")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Email sent successfully"),
	    @ApiResponse(responseCode = "500", description = "Failed to send email") })
    @PostMapping("/send")
    public ResponseEntity<String> sendMail(
	    @Parameter(description = "The mail configuration key to use for sending email") @RequestParam String configurationKey,
	    @Parameter(description = "Recipient email address") @RequestParam String to,
	    @Parameter(description = "Subject of the email") @RequestParam String subject,
	    @Parameter(description = "Body of the email") @RequestBody String body,
	    @Parameter(description = "Template name to use for the email body") @RequestParam String template,
	    @Parameter(description = "CC recipients (optional)") @RequestParam(required = false) String cc) {
	try {
	    mailService.sendMail(configurationKey, to, subject, body, cc, template);
	    return ResponseEntity.ok("Email sent successfully.");
	} catch (Exception e) {
	    return ResponseEntity.status(500).body("Failed to send email: " + e.getMessage());
	}
    }
}
