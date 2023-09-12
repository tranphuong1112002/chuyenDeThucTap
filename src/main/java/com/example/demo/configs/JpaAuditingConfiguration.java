package com.example.demo.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.ZonedDateTime;
import java.util.Optional;

/**
 * Class Config time and auditor
 *
 * @author thuydang
 * @since 8/5/2022
 */
@Slf4j
@Configuration
@EnableJpaAuditing(auditorAwareRef = "currentAuditor", dateTimeProviderRef = "dateTimeProvider")
public class JpaAuditingConfiguration {

  @Bean
  public DateTimeProvider auditingDateTimeProvider() {
    return () -> Optional.of(ZonedDateTime.now());
  }
}