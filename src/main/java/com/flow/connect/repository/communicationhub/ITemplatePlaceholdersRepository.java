package com.flow.connect.repository.communicationhub;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flow.connect.repository.communicationhub.dao.TemplatePlaceholder;

public interface ITemplatePlaceholdersRepository extends JpaRepository<TemplatePlaceholder,Long> {

}
