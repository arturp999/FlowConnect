package com.flow.connect.repository.communicationhub.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "mailing_templates")
public class MailingTemplates {

    @Id
    @Column(name = "template_code", length = 255)
    private String templateCode;

    @Column(name = "subject", length = 255, nullable = false)
    private String subject;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

//    @OneToMany(mappedBy = "mailingTemplate", fetch = FetchType.LAZY)
//    private List<TemplatePlaceholder> placeholders;
 
}
