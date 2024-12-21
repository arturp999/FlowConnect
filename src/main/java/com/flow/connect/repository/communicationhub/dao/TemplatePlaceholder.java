package com.flow.connect.repository.communicationhub.dao;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "template_placeholders")
@Data
@Builder
public class TemplatePlaceholder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placeholder_id")
    private int placeholderId;

    @Column(name = "template_code", length = 255, nullable = false)
    private String templateCode;

    @Column(name = "placeholder_name", length = 255, nullable = false)
    private String placeholderName;

    @Column(name = "placeholder_description", length = 500)
    private String placeholderDescription;

    @ManyToOne
    private MailingTemplate mailingTemplate;
 
}
