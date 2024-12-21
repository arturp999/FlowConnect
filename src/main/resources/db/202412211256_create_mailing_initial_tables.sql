--liquibase formatted sql
-- Changeset arturpereira:202412211256
-- Description: Create mailing_templates and template_placeholders tables if they do not exist.
-- Author: arturpereira
-- Date: 2024-12-21 12:56

-- Create the mailing_templates table if it does not already exist
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'mailing_templates' AND type = 'U')
BEGIN
    CREATE TABLE mailing_templates (
        template_code VARCHAR(50) PRIMARY KEY,     -- Unique code for the template
        subject VARCHAR(255) NOT NULL,              -- Subject of the email
        body VARCHAR(MAX) NOT NULL,                 -- Email body with placeholders
        description VARCHAR(200),                   -- Optional description of the template
        is_active BIT NOT NULL DEFAULT 1,           -- Status flag (active/inactive)
        create_date DATETIME NOT NULL,              -- Creation timestamp
        create_user VARCHAR(255) NOT NULL,          -- Creator's username or ID
        update_date DATETIME NOT NULL,              -- Last update timestamp
        update_user VARCHAR(255) NOT NULL           -- Last updater's username or ID
    );
END

-- Create the template_placeholders table if it does not already exist
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'template_placeholders' AND type = 'U')
BEGIN
    CREATE TABLE template_placeholders (
        placeholder_id BIGINT IDENTITY(1,1) PRIMARY KEY, -- Unique ID for the placeholder
        template_code VARCHAR(50),                        -- Foreign key reference to `mailing_templates`
        placeholder_name VARCHAR(50) NOT NULL,            -- Placeholder name (e.g., ${name})
        placeholder_description VARCHAR(500),            -- Description of what the placeholder is for
        create_date DATETIME NOT NULL,                    -- Creation timestamp
        create_user VARCHAR(255) NOT NULL,                -- Creator's username or ID
        update_date DATETIME NOT NULL,                    -- Last update timestamp
        update_user VARCHAR(255) NOT NULL,                -- Last updater's username or ID
        FOREIGN KEY (template_code) REFERENCES mailing_templates(template_code)  -- FK to the templates
    );
END
