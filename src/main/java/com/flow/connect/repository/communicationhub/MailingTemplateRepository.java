package com.flow.connect.repository.communicationhub;


import org.springframework.data.jpa.repository.JpaRepository;

import com.flow.connect.repository.communicationhub.dao.MailingTemplates;

public interface MailingTemplateRepository extends JpaRepository<MailingTemplates, String> {


    
    
}
